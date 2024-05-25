import os
import numpy as np
import librosa
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder
from tensorflow.keras import layers, models

var_sample_rate = 16000

#mfcc feature extraction
def extract_features(file_path):
    try:
        print(file_path)
        audio, sample_rate = librosa.load(file_path, sr=var_sample_rate)
        mfccs = librosa.feature.mfcc(y=audio, sr=sample_rate, n_mfcc=40)
        mfccs_processed = np.mean(mfccs.T,axis=0)
    except Exception as e:
        # print("Error encountered while parsing file: ", file_path)
        print(e)
        return None
    return mfccs_processed

data_dir = "training_data"
features = []
labels = []

# go through each speaker
for speaker_folder in os.listdir(data_dir):
    speaker_path = os.path.join(data_dir, speaker_folder)
    if os.path.isdir(speaker_path):
        # iterate over all audio files
        for file_name in os.listdir(speaker_path)[:1800]:
            if file_name.endswith(".wav"):
                file_path = os.path.join(speaker_path, file_name)
                feature = extract_features(file_path)
                if feature is not None:
                    features.append(feature)
                    labels.append(speaker_folder)

label_encoder = LabelEncoder()
encoded_labels = label_encoder.fit_transform(labels)
X_train, X_test, y_train, y_test = train_test_split(features, encoded_labels, test_size=0.2, random_state=42)

# mode architecture
model = models.Sequential([
    layers.Dense(256, activation='relu', input_shape=(40,)),
    layers.Dense(128, activation='relu'),
    layers.Dense(64, activation='relu'),
    layers.Dense(len(label_encoder.classes_), activation='softmax')
])

model.compile(optimizer='adam', loss='sparse_categorical_crossentropy', metrics=['accuracy'])
model.fit(np.array(X_train), np.array(y_train), epochs=50, batch_size=32, validation_data=(np.array(X_test), np.array(y_test)))
model.save("model_one.keras")
np.save("label_encoder_one.npy", label_encoder.classes_)
