import os
import wave

def split_wav(input_wav, output_dir, chunk_duration=5):
    """
    Splits a WAV file into chunks of specified duration.

    Parameters:
        input_wav (str): Path to the input WAV file.
        output_dir (str): Directory to save the output chunks.
        chunk_duration (int): Duration of each chunk in seconds.
    """
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)

    with wave.open(input_wav, 'rb') as wf:
        frame_rate = wf.getframerate()
        frame_width = wf.getsampwidth()
        num_frames = wf.getnframes()
        num_channels = wf.getnchannels()
        total_duration = num_frames / frame_rate

        chunk_frames = int(chunk_duration * frame_rate)

        for i in range(0, num_frames, chunk_frames):
            wf.setpos(i)
            chunk_data = wf.readframes(chunk_frames)
            chunk_file_path = os.path.join(output_dir, f"sania_chunk_{i // frame_rate}.wav")
            with wave.open(chunk_file_path, 'wb') as chunk_wf:
                chunk_wf.setnchannels(num_channels)
                chunk_wf.setsampwidth(frame_width)
                chunk_wf.setframerate(frame_rate)
                chunk_wf.writeframes(chunk_data)

input_wav = r"audio\speaker.wav"  # Path to the input WAV file, replace with actual file path
output_dir = "training_data\speaker"  # Directory to save the output chunks, replace speaker with speaker name
split_wav(input_wav, output_dir)
