# Speaker Recognition Project

## Overview

This project is a Streamlit application designed for speaker recognition. It allows users to sign up, log in, and use various functionalities like recording live audio, uploading audio files, predicting the speaker using a pre-trained model, and retrieving past transcriptions. The application also features a database to store user information and transcription history.

## Features

1. **User Authentication:**
   - Signup and login functionality using bcrypt for password hashing.
   - User data stored in a SQLite database.

2. **Speaker Recognition:**
   - Record live audio or upload audio files for speaker recognition.
   - Transcriptions generated using Google's Speech Recognition API.
   - Speaker prediction using a pre-trained Keras model.

3. **Transcription History:**
   - Store and retrieve past transcriptions.
   - Download transcriptions as a text file.

## Setup

### Prerequisites

- Python 3.6+
- Streamlit
- NumPy
- PyAudio
- Librosa
- TensorFlow
- Scikit-learn
- Soundfile
- SpeechRecognition
- Bcrypt
- SQLite3

### Installation

```sh
git clone https://github.com/yourusername/speaker-recognition-app.git

cd speaker-recognition-app

python -m venv venv

venv\Scripts\activate

pip install -r requirements.txt

streamlit run app.py
```

## Usage

### Sign Up

1. Select the "Sign Up" option.
2. Enter your email and password.
3. Click "Sign Up" to create your account.

### Login

1. Select the "Login" option.
2. Enter your email and password.
3. Click "Login" to access the application features.

### Speaker Recognition

1. After logging in, choose an option to identify the speaker:
   - **Upload Audio File:** Upload `.wav` files for prediction.
   - **Record Live Audio:** Record live audio using your microphone.
   - **Retrieve Past Transcriptions:** View and download previous transcriptions.
2. Follow the on-screen instructions to upload or record audio.
3. View the predicted speaker and transcription.
4. Download transcriptions if needed.

## File Structure

- `app.py`: Main Streamlit application file.
- `setup_database.py`: Script to set up the SQLite database.
- `requirements.txt`: List of required Python packages.
- `model_one.keras`: Pre-trained Keras model for speaker prediction.
- `label_encoder_one.npy`: Label encoder for the model.

## Database Schema

### Users Table

- `id`: INTEGER, primary key
- `email`: VARCHAR(50), unique
- `password`: VARCHAR(60)
- `status`: VARCHAR(20)
- `created_dt`: DATETIME, default current timestamp

### History Table

- `id`: INTEGER, primary key
- `user_id`: INTEGER, foreign key references `users(id)`
- `name`: TEXT
- `transcription_file`: BLOB
- `created_dt`: DATETIME, default current timestamp
- `updated_dt`: DATETIME, default current timestamp

## Notes

- Ensure the `model_one.keras` and `label_encoder_one.npy` files are in the project directory.
- The app uses Google's Speech Recognition API, which requires an internet connection.
- Audio recording functionality requires a working microphone.


## Database Setup
To manually set up the SQLite database for user management and history tracking, follow these steps:

### Working Directory: `db_helpers`
1. Make Database: Use make_db.py to create the SQLite database with the required tables (users and history).

   ```sh
   python make_db.py
   ```

2. Check Database (Optional): Use check_db.py to check the existing tables and records in the database.

   ```sh
   python check_db.py
   ```

Note: These scripts assume the database file (`voice_db.db`) is created in the same directory as the scripts. Adjust the database file path if necessary.

For training on different/new data, check `training.md`


## License

This project is licensed under the MIT License.
