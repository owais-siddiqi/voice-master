import sqlite3

# Connect to SQLite database
conn = sqlite3.connect("user_database.db")
cursor = conn.cursor()

# Function to print tables and records
def print_tables_and_records():
    # Get list of tables
    cursor.execute("SELECT name FROM sqlite_master WHERE type='table';")
    tables = cursor.fetchall()

    # Print tables and records
    for table in tables:
        table_name = table[0]
        print(f"Table: {table_name}")
        cursor.execute(f"PRAGMA table_info({table_name})")
        columns = cursor.fetchall()
        column_names = [column[1] for column in columns]
        print("Columns:", column_names)

        cursor.execute(f"SELECT * FROM {table_name}")
        records = cursor.fetchall()
        print("Records:")
        for record in records:
            print(record)
        print()

# Call the function to print tables and records
print_tables_and_records()

# Close database connection
conn.close()
