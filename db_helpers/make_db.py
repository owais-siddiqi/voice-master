import sqlite3
from datetime import datetime

# Connect to the SQLite database (creates if not exists)
conn = sqlite3.connect('voice_db.db')
cursor = conn.cursor()

# Create the users table
cursor.execute('''
    CREATE TABLE IF NOT EXISTS users (
        id INTEGER PRIMARY KEY,
        email VARCHAR(50) UNIQUE,
        password VARCHAR(60),
        status VARCHAR(20),
        created_dt DATETIME DEFAULT CURRENT_TIMESTAMP
    )
''')

# Create the history table
cursor.execute('''
    CREATE TABLE IF NOT EXISTS history (
        id INTEGER PRIMARY KEY,
        user_id INTEGER,
        name TEXT,
        transcription_file TEXT,
        created_dt DATETIME DEFAULT CURRENT_TIMESTAMP,
        updated_dt DATETIME DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (user_id) REFERENCES users(id)
    )
''')

# Commit changes and close connection
conn.commit()
conn.close()

print("Database created and successfully.")
