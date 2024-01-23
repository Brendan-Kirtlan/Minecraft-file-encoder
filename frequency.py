from collections import Counter

def calculate_and_print_frequency(input_file):
    try:
        # Read the content of the encrypted file
        with open(input_file, 'r') as file:
            encrypted_content = file.read()

        # Count the frequency of each letter
        letter_frequency = Counter(encrypted_content)

        total_characters = len(encrypted_content)

        # Sort the letter frequency in descending order
        sorted_frequency = sorted(letter_frequency.items(), key=lambda x: x[1], reverse=True)

        # Print the frequency and percentage of each letter in descending order
        for letter, count in sorted_frequency:
            if letter.isalpha():  # Exclude non-alphabetic characters
                percentage = (count / total_characters) * 100
                print(f"{letter}: {count} ({percentage:.2f}%)")

    except FileNotFoundError:
        print(f"Error: File '{input_file}' not found.")

if __name__ == "__main__":
    # Input file name (encrypted.txt)
    input_file_name = "encrypted.txt"  # Replace with your encrypted file

    # Calculate and print letter frequency with percentages in descending order
    calculate_and_print_frequency(input_file_name)
