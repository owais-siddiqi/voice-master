from flask import Flask, render_template, request, jsonify
import pyaudio
import numpy as np
import tensorflow as tf
import io

app = Flask(__name__)

# Load the trained model
model = tf.keras.models.load_model("model_zero.h5")
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

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/process_audio', methods=['POST'])
def process_audio():
    audio_file = request.files['audio']
    audio = io.BytesIO(audio_file.read())
    audio.seek(0)
    audio_data = np.frombuffer(audio.read(), dtype=np.int16)
    audio_data = audio_data.astype(np.float32)  # Convert data type to float32
    predicted_speaker = predict_speaker(audio_data)
    return jsonify({'predicted_speaker': predicted_speaker})


if __name__ == "__main__":
    app.run(debug=True)
