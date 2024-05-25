# Speaker Recognition Training Script

This script is used to train a speaker recognition model using audio data. It extracts MFCC features from audio files, preprocesses the data, and trains a neural network model for speaker recognition. The trained model and label encoder classes are saved for later use.

## Setup

### Prerequisites

- Python 3.6+
- NumPy
- Librosa
- Scikit-learn
- TensorFlow

### Preprocessing Data
Check `helper.md ` in the `helper_functions` directory for guidance on preparing data for training. 

### Installation

1. Install the required Python packages:
   ```sh
   pip install numpy librosa scikit-learn tensorflow
   ```

2. Organize your audio data in the following directory structure:

   ```
   training_data
   ├── speaker1
   │   ├── audio_file1.wav
   │   ├── audio_file2.wav
   │   └── ...
   ├── speaker2
   │   ├── audio_file1.wav
   │   ├── audio_file2.wav
   │   └── ...
   └── ...
   ```



## Usage

1. Update the `data_dir` variable in the script to point to your training data directory.
2. Run the script to train the model:

```sh
python train_model.py
```

## Script Overview
- Feature Extraction: MFCC features are extracted from each audio file using the extract_features function.
- Data Preparation: Features and corresponding speaker labels are collected from all audio files.
- Label Encoding: Speaker labels are encoded using LabelEncoder from scikit-learn.
- Train-Test Split: Data is split into training and testing sets using train_test_split from scikit-learn.
- Model Architecture: The neural network model architecture is defined using Sequential from Keras.
- Model Compilation: The model is compiled with the Adam optimizer and sparse categorical cross-entropy loss.
- Model Training: The model is trained on the training data for 50 epochs with a batch size of 32.
- Model Saving: The trained model and label encoder classes are saved to disk for later use.

## File Structure
- `train_model.py`: The main training script.
- training_data: Directory containing audio files organized by speaker.

## Notes
Ensure the audio files are in WAV format and have a sample rate of 16,000 Hz.
This script assumes each speaker has a maximum of 1800 audio files. Adjust the loop logic if your data differs.