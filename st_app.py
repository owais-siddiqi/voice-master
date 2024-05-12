import time
import streamlit as st
import pyaudio
import numpy as np
import tensorflow as tf
import speech_recognition as sr
import matplotlib.pyplot as plt

# Load the trained model
model = tf.keras.models.load_model("model_zero.h5")

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
def predict_speaker(audio):
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

# Streamlit app
def main():
    st.title("Speaker Recognition and Speech Transcription")

    st.write("Press the button to start recording...")

    if st.button("Start Recording"):
        audio = record_audio()
        predicted_speaker = predict_speaker(audio)
        transcription = transcribe_speech(audio)

        st.write(f"Predicted Speaker: {predicted_speaker}")
        st.write(f"Transcription: {transcription}")

if __name__ == "__main__":
    main()
