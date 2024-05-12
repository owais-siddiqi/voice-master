import pyaudio
import numpy as np
import tensorflow as tf
from pathlib import Path

# Define paths and variables
data_directory = "training_data"
audio_folder = ["owais", "usman"]  # Subfolders for each speaker
sample_rate = 16000  # Sample rate of audio files

# Load the trained model
model = tf.keras.models.load_model("voice_master_model.h5")

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

# Record audio from the user
def record_audio():
    audio = []
    p = pyaudio.PyAudio()
    stream = p.open(format=FORMAT,
                    channels=CHANNELS,
                    rate=RATE,
                    input=True,
                    frames_per_buffer=CHUNK)

    print("Recording...")
    for i in range(0, int(RATE / CHUNK * RECORD_SECONDS)):
        data = stream.read(CHUNK)
        audio.append(np.frombuffer(data, dtype=np.int16))

    print("Finished recording")
    stream.stop_stream()
    stream.close()
    p.terminate()

    audio = np.concatenate(audio)
    return audio

# Main function
def main():
    while True:
        input("Press Enter to start recording...")
        audio = record_audio()
        predicted_speaker = predict_speaker(audio)
        print("Predicted Speaker:", predicted_speaker)

if __name__ == "__main__":
    main()
