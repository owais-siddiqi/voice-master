import os
import random
import tensorflow as tf
from tensorflow import keras
from pathlib import Path

# Define paths
data_directory = "training_data"
audio_folder = ["owais", "usman", "bilal"]  # Subfolders for each speaker
sample_rate = 16000  # Sample rate of audio files
valid_split = 0.1  # Fraction of data to use for validation
batch_size = 128
epochs = 100
scale = 0.5  # Scale for adding noise

# Function to load audio samples
def path_to_audio(path):
    audio = tf.io.read_file(path)
    audio, _ = tf.audio.decode_wav(audio, 1, sample_rate)
    return audio

# Function to create dataset from paths and labels
def paths_and_labels_to_dataset(audio_paths, labels):
    path_ds = tf.data.Dataset.from_tensor_slices(audio_paths)
    audio_ds = path_ds.map(lambda x: path_to_audio(x))
    label_ds = tf.data.Dataset.from_tensor_slices(labels)
    return tf.data.Dataset.zip((audio_ds, label_ds))

# Load audio paths and corresponding labels
audio_paths = []
labels = []
for label, name in enumerate(audio_folder):
    dir_path = Path(data_directory) / name
    speaker_sample_paths = [
        os.path.join(dir_path, filepath)
        for filepath in os.listdir(dir_path)
        if filepath.endswith(".wav")
    ]
    audio_paths += speaker_sample_paths
    labels += [label] * len(speaker_sample_paths)

# Convert labels to integers
labels = [int(label) for label in labels]

# Combine audio paths and labels
combined = list(zip(audio_paths, labels))

# Shuffle the combined list using random.shuffle()
random.seed(123)
random.shuffle(combined)

# Unzip the shuffled list
audio_paths[:], labels[:] = zip(*combined)

# Split into training and validation sets
num_val_samples = int(valid_split * len(audio_paths))
train_audio_paths = audio_paths[:-num_val_samples]
train_labels = labels[:-num_val_samples]
valid_audio_paths = audio_paths[-num_val_samples:]
valid_labels = labels[-num_val_samples:]

# Create datasets
train_ds = paths_and_labels_to_dataset(train_audio_paths, train_labels)
valid_ds = paths_and_labels_to_dataset(valid_audio_paths, valid_labels)

# Preprocess datasets
train_ds = train_ds.shuffle(buffer_size=batch_size * 8).batch(batch_size)
valid_ds = valid_ds.batch(batch_size)

# Build the model
def build_model(input_shape, num_classes):
    inputs = keras.layers.Input(shape=input_shape, name="input")
    # Define model architecture here, same as the provided code
    # Modify the architecture as needed based on your dataset
    # Example architecture:
    x = keras.layers.Conv1D(16, 3, activation="relu")(inputs)
    x = keras.layers.MaxPooling1D(2)(x)
    x = keras.layers.Conv1D(32, 3, activation="relu")(x)
    x = keras.layers.MaxPooling1D(2)(x)
    x = keras.layers.Conv1D(64, 3, activation="relu")(x)
    x = keras.layers.MaxPooling1D(2)(x)
    x = keras.layers.Flatten()(x)
    x = keras.layers.Dense(128, activation="relu")(x)
    outputs = keras.layers.Dense(num_classes, activation="softmax", name="output")(x)
    return keras.models.Model(inputs=inputs, outputs=outputs)

# Create model
model = build_model((sample_rate, 1), len(audio_folder))

# Compile model
model.compile(optimizer="adam", loss="sparse_categorical_crossentropy", metrics=["accuracy"])

# Train model
history = model.fit(train_ds, epochs=epochs, validation_data=valid_ds)

# Evaluate model
loss, accuracy = model.evaluate(valid_ds)
print("Validation Accuracy:", accuracy)

# Plot training history
import matplotlib.pyplot as plt

plt.plot(history.history["accuracy"], label="accuracy")
plt.plot(history.history["val_accuracy"], label="val_accuracy")
plt.xlabel("Epoch")
plt.ylabel("Accuracy")
plt.legend()
plt.show()

# Save the trained model
model.save("voice_master_model.h5")

# Make predictions
predictions = model.predict(valid_ds)
