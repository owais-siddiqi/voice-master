import os

def rename_wav_files(directory):
    if not os.path.isdir(directory):
        print("Directory does not exist.")
        return
    
    # Iterate over each file in the directory
    for index, filename in enumerate(os.listdir(directory)):
        if filename.endswith(".wav"):

            new_filename = f"{index + 1}.wav"
            old_filepath = os.path.join(directory, filename)
            new_filepath = os.path.join(directory, new_filename)

            try:
                os.rename(old_filepath, new_filepath)
                print(f"Renamed '{filename}' to '{new_filename}'")
            except Exception as e:
                print(f"Error renaming '{filename}': {e}")

# Replace 'directory_path' with the path to your directory containing the WAV files
directory_path = r"training_data\speaker" # replace speaker with actual speaker name
rename_wav_files(directory_path)
