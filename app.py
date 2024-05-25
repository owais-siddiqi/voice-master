import streamlit as st
import numpy as np
import pyaudio
import librosa
from tensorflow.keras.models import load_model
from sklearn.preprocessing import LabelEncoder
import soundfile as sf
import speech_recognition as sr
import io
import sqlite3
from datetime import datetime
import os
import bcrypt

def hash_password(password): #hash password b4 storing
    salt = bcrypt.gensalt()
    hashed_password = bcrypt.hashpw(password.encode('utf-8'), salt)
    return hashed_password.decode('utf-8')

# connect db
DATABASE_URL = "voice_db.db"
conn = sqlite3.connect(DATABASE_URL)
cursor = conn.cursor()

# if table doesnt exists, create table
cursor.execute('''
    CREATE TABLE IF NOT EXISTS users (
        id INTEGER PRIMARY KEY,
        email VARCHAR(50) UNIQUE,
        password VARCHAR(60),
        status VARCHAR(20),
        created_dt DATETIME DEFAULT CURRENT_TIMESTAMP
    )
''')
conn.commit()

cursor.execute('''
    CREATE TABLE IF NOT EXISTS history (
        id INTEGER PRIMARY KEY,
        user_id INTEGER,
        name TEXT,
        transcription_file BLOB,
        created_dt DATETIME DEFAULT CURRENT_TIMESTAMP,
        updated_dt DATETIME DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (user_id) REFERENCES users(id)
    )
''')
conn.commit()

# for storing user after signing up
def insert_user(email, password):
    success  = False
    try:
        hashed_password = hash_password(password)
        cursor.execute('''
            INSERT INTO users (email, password, status, created_dt)
            VALUES (?, ?, ?, ?)
        ''', (email, hashed_password, 'active', datetime.now()))
        conn.commit()
        success = True
    except sqlite3.IntegrityError:
        st.error("Email already exists. Please choose a different email.")
    except Exception as e:
        st.error(f"An error occurred: {str(e)}")

    return success

# check db for user
def check_user(email, password):
    try:
        cursor.execute('''
            SELECT * FROM users WHERE email = ?
        ''', (email,))
        user = cursor.fetchone()
        if user:
            hashed_password = user[2]  # Fetch hashed password from database
            if bcrypt.checkpw(password.encode('utf-8'), hashed_password.encode('utf-8')):
                return user[0]  # Return user id
        return None
    except Exception as e:
        st.error(f"An error occurred: {str(e)}")

# loading model
model = load_model("model_one.keras")

# loading labels for predictions
label_encoder = LabelEncoder()
label_encoder.classes_ = np.load("label_encoder_one.npy")

# mfcc feature extraction
def extract_features(audio_input, sample_rate):
    try:
        mfccs = librosa.feature.mfcc(y=audio_input, sr=sample_rate, n_mfcc=40)
        mfccs_processed = np.mean(mfccs.T,axis=0)
    except Exception as e:
        print("Error encountered while processing audio input.")
        return None
    return mfccs_processed

def predict_speaker(audio_input):
    feature = extract_features(audio_input, sample_rate=22050)  # Assuming common sample rate
    if feature is not None:
        feature = np.expand_dims(feature, axis=0) # Add batch dimension
        predictions = model.predict(feature)
        predicted_label = label_encoder.inverse_transform([np.argmax(predictions)])
        return predicted_label[0]
    else:
        return "unknown"

def record_audio(duration=5, sample_rate=16000, chunk_size=1024):
    audio = pyaudio.PyAudio()
    stream = audio.open(format=pyaudio.paFloat32, channels=1,
                        rate=sample_rate, input=True,
                        frames_per_buffer=chunk_size)
    st.write("Recording...")
    frames = []
    for i in range(0, int(sample_rate / chunk_size * duration)):
        data = stream.read(chunk_size)
        frames.append(data)
    st.write("Recording finished.")
    stream.stop_stream()
    stream.close()
    audio.terminate()
    return np.frombuffer(b''.join(frames), dtype=np.float32)

def transcribe_audio(audio_data, sample_rate):
    recognizer = sr.Recognizer()
    audio_file = io.BytesIO()
    sf.write(audio_file, audio_data, sample_rate, format='wav')  # Specify the format as WAV
    audio_file.seek(0)
    with sr.AudioFile(audio_file) as source:
        audio = recognizer.record(source, duration=None, offset=0)
    try:
        transcription = recognizer.recognize_google(audio, language="en-US")
    except sr.UnknownValueError:
        transcription = "Google Speech Recognition could not understand audio"
    except sr.RequestError as e:
        transcription = "Could not request results from Google Speech Recognition service; {0}".format(e)
    return transcription

# Streamlit app
st.title("Speaker Recognition")

# Signup and login section
page = st.radio("Select an option:", ["Sign Up", "Login"])

if page == "Sign Up":
    st.subheader("Sign Up")
    email = st.text_input("Email")
    password = st.text_input("Password", type="password")
    if st.button("Sign Up"):
        if email and password:
            v_succ = insert_user(email, password)
            if v_succ:
                st.success("Account created successfully. Please log in.")
            page = "Login"
        else:
            st.error("Email and password are required.")

elif page == "Login":
    st.subheader("Login")
    email = st.text_input("Email")
    password = st.text_input("Password", type="password")
    if st.button("Login"):
        if email and password:
            user_id = check_user(email, password)
            if user_id:
                st.success("Logged in successfully.")
                st.session_state.user_id = user_id  # Set user_id session state
            else:
                st.error("Invalid email or password. Please try again.")
        else:
            st.error("Email and password are required.")

if page == "Login":
    st.subheader("Speaker Recognition")

    # if loggedin, show voice recognition features
    if st.session_state.get('user_id'):
        st.write("Choose an option to identify the speaker:")
        option = st.selectbox(
            'Select an option:',
            ('Upload Audio File', 'Record Live Audio', 'Retrieve Past Transcriptions')
        )

        transcriptions = []  #store transcriptions
        speakers = []  # store predicted speakers

        if option == 'Upload Audio File':
            uploaded_files = st.file_uploader("Choose audio files", type=['wav'], accept_multiple_files=True)
            if uploaded_files is not None:
                for uploaded_file in uploaded_files:
                    audio_data, sample_rate = librosa.load(uploaded_file, sr=None)
                    st.audio(uploaded_file, format='audio/wav')
                    transcription = transcribe_audio(audio_data, sample_rate)
                    speaker_label = predict_speaker(audio_data)
                    speakers.append(speaker_label)
                    transcriptions.append(transcription)
                    # insert into history table
                    cursor.execute('''
                        INSERT INTO history (user_id, name, transcription_file)
                        VALUES (?, ?, ?)
                    ''', (st.session_state.user_id, uploaded_file.name, transcription))
                    conn.commit()

        elif option == 'Record Live Audio':
            st.write("Click the button below to start recording and identify the speaker.")
            if st.button("Start Recording"):
                duration = 5
                live_audio_input = record_audio(duration=duration)
                st.audio(live_audio_input, format='audio/wav', sample_rate=16000)
                transcription = transcribe_audio(live_audio_input, sample_rate=16000)
                speaker_label = predict_speaker(live_audio_input)
                speakers.append(speaker_label)
                transcriptions.append(transcription)
                # insert into history table
                cursor.execute('''
                    INSERT INTO history (user_id, name, transcription_file)
                    VALUES (?, ?, ?)
                ''', (st.session_state.user_id, "Live Audio", sqlite3.Binary(live_audio_input)))
                conn.commit()

        elif option == 'Retrieve Past Transcriptions':
            cursor.execute('''
                SELECT name, transcription_file FROM history WHERE user_id = ?
            ''', (st.session_state.user_id,))
            past_transcriptions = cursor.fetchall()
            if past_transcriptions:
                st.write("Past Transcriptions:")
                for name, transcription_file in past_transcriptions:
                    st.write("File Name:", name)
                    st.text_area("Transcription:", transcription_file)
                    st.write("---")
            else:
                st.write("No past transcriptions available.")




        # display transcriptions if available
        if transcriptions:
            st.write("Transcriptions:")
            for speaker, transcription in zip(speakers, transcriptions):
                st.write("Predicted speaker:", speaker)
                st.text_area("Transcription:", transcription)
                st.write("---")
            
            st.write("Click the button below to download transcriptions.")
            transcriptions_text = "\n\n".join([f"Predicted Speaker: {speaker}\n\n{transcription}\n\n-------------------------------------------------------------------------------" for speaker, transcription in zip(speakers, transcriptions)])
            download_button = st.download_button(
                label="Download Transcriptions",
                data=transcriptions_text.encode(),
                file_name="transcriptions.txt",
                mime="text/plain"
            )
    else:
        st.info("Please log in to access speaker recognition features.")

# close database connection
conn.close()
