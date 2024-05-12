import time
from matplotlib import pyplot as plt
import streamlit as st
import pyaudio
import numpy as np
import tensorflow as tf
import speech_recognition as sr
import hashlib
import sqlite3
import warnings


# Suppress the warning about compiled metrics
warnings.filterwarnings("ignore", message="Compiled the loaded model, but the compiled metrics have yet to be built")
# Connect to the SQLite database
conn = sqlite3.connect("projectdb")
cursor = conn.cursor()

# Load the trained model
@st.cache_data
def load_model():
    return tf.keras.models.load_model("model_zero.h5", compile=False)

# Define paths and variables
audio_folder = ["owais", "usman"]  # Subfolders for each speaker
sample_rate = 16000  # Sample rate of audio files

# Define the audio recording parameters
FORMAT = pyaudio.paInt16
CHANNELS = 1
RATE = 16000
CHUNK = 1024
RECORD_SECONDS = 5

# Function to preprocess audio
def preprocess_audio(audio):
    # Ensure audio length is less than or equal to sample_rate
    if len(audio) > sample_rate:
        audio = audio[:sample_rate]
    else:
        # Pad if audio length is less than sample_rate
        pad_width = sample_rate - len(audio)
        audio = np.pad(audio, (0, pad_width), mode='constant')
    audio = audio.reshape(1, -1, 1)
    return audio

# Function to predict speaker
def predict_speaker(audio, model):
    preprocessed_audio = preprocess_audio(audio)
    predictions = model.predict(preprocessed_audio)
    predicted_speaker_index = np.argmax(predictions)
    return audio_folder[predicted_speaker_index]

# Function to transcribe speech
def transcribe_speech(audio):
    recognizer = sr.Recognizer()
    audio_data = sr.AudioData(audio, sample_rate=RATE, sample_width=2)
    try:
        text = recognizer.recognize_google(audio_data)
    except sr.UnknownValueError:
        text = "Could not understand audio"
    except sr.RequestError as e:
        text = "Could not request results"
    return text

# Record audio from the user
def record_audio():
    print("Started recording")
    audio = []
    p = pyaudio.PyAudio()
    stream = p.open(format=FORMAT,
                    channels=CHANNELS,
                    rate=RATE,
                    input=True,
                    frames_per_buffer=CHUNK)

    st.text("Recording...")

    fig, ax = plt.subplots()
    x = np.arange(0, 2 * CHUNK, 2)
    line, = ax.plot(x, np.random.rand(CHUNK))

    ax.set_ylim(-2**15, 2**15)
    ax.set_xlim(0, CHUNK)

    start_time = time.time()

    while time.time() - start_time < RECORD_SECONDS:
        data = stream.read(CHUNK)
        audio.append(np.frombuffer(data, dtype=np.int16))
        line.set_ydata(np.frombuffer(data, dtype=np.int16))
        fig.canvas.draw()
        fig.canvas.flush_events()

    st.text("Finished recording")
    stream.stop_stream()
    stream.close()
    p.terminate()

    audio = np.concatenate(audio)
    plt.close()
    return audio

# Function to register a new user
def register_user(email, password):
    hashed_password = hashlib.sha256(password.encode()).hexdigest()
    cursor.execute("INSERT INTO users (Email, Password, Status, CreateDt) VALUES (?, ?, ?, datetime('now'))", (email, hashed_password, "Active"))
    conn.commit()

# Function to login
def login_user(email, password):
    hashed_password = hashlib.sha256(password.encode()).hexdigest()
    cursor.execute("SELECT Id FROM users WHERE Email = ? AND Password = ?", (email, hashed_password))
    user_id = cursor.fetchone()
    if user_id:
        return user_id[0]
    else:
        return None

# Function to logout
def logout_user():
    st.session_state.clear()
    # Redirect the user to the login page by rerunning the app
    st.experimental_rerun()

# Function to save audio history
def save_audio_history(user_id, name, audio_blob):
    cursor.execute("INSERT INTO history (user_id, name, audio) VALUES (?, ?, ?)", (user_id, name, audio_blob))
    conn.commit()

# Streamlit app
def main():
    st.title("Speaker Recognition and Speech Transcription")

    # Load the model
    model = load_model()

    # Initialize session state if not already initialized
    if 'recording_started' not in st.session_state:
        st.session_state.recording_started = False

    # Login Section
    st.subheader("Login")
    email = st.text_input("Email")
    password = st.text_input("Password", type="password")
    if st.button("Login"):
        user_id = login_user(email, password)
        if user_id:
            st.success("Login successful!")
            st.write("Press the button to start recording...")
            if st.button("Start Recording"):
                st.session_state.recording_started = True  # Set recording flag to True

    # Recording Section
    if st.session_state.recording_started:
        st.write("Recording...")
        audio = record_audio()
        predicted_speaker = predict_speaker(audio, model)
        transcription = transcribe_speech(audio)

        st.write("Voice Recognition Results:")
        st.write(f"Predicted Speaker: {predicted_speaker}")
        st.write(f"Transcription: {transcription}")

    # Register Section
    st.subheader("Register")
    new_email = st.text_input("New Email")
    new_password = st.text_input("New Password", type="password")
    if st.button("Register"):
        # Check if email already exists
        cursor.execute("SELECT Id FROM users WHERE Email = ?", (new_email,))
        existing_user = cursor.fetchone()
        if existing_user:
            st.error("Email already in use.")
        else:
            register_user(new_email, new_password)
            st.success("Registration successful!")

if __name__ == "__main__":
    main()
