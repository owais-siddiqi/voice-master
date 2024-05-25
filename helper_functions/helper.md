## Helper Functions

This section includes descriptions and usage instructions for helper scripts that complement the main training script. These scripts provide additional functionality for preprocessing and organizing audio data, making it easier to prepare the data for training the speaker recognition model.

### `splitfive.py`

`splitfive.py` is a Python script that splits a WAV file into chunks of a specified duration. This can be useful for breaking down long audio recordings into smaller segments for training or processing.

#### Usage

1. Place `splitfive.py` in your project directory.
2. Use `split_wav(input_wav, output_dir, chunk_duration)` to split your WAV file.
   - `input_wav`: Path to the input WAV file.
   - `output_dir`: Directory to save the output chunks.
   - `chunk_duration`: Duration of each chunk in seconds.

### `rename_dir.py`

`rename_dir.py` is a Python script that renames WAV files in a directory. This can be useful for ensuring that files are named consistently or for numbering files sequentially.

#### Usage

1. Place `rename_dir.py` in your project directory.
2. Use `rename_wav_files(directory)` to rename WAV files in a directory.
   - `directory`: Path to the directory containing the WAV files.
