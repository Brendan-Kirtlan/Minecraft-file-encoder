import re

def load_encrypted_message(file_path):
    with open(file_path, 'r') as file:
        return file.read()

def save_decrypted_message(decrypted_message, file_path):
    with open(file_path, 'w') as file:
        file.write(decrypted_message)

def display_message(encrypted_message, decrypted_message):
    print("Encrypted Message:")
    print(encrypted_message)
    print("\nDecrypted Message:")
    print(decrypted_message)

def decrypt(message, decryption_mapping):
    decrypted_message = ''.join(decryption_mapping.get(char, char) for char in message)
    return decrypted_message

def main():
    file_path = 'encrypted.txt'
    encrypted_message = load_encrypted_message(file_path)

    decryption_mapping = {}
    
    while True:
        decrypted_message = decrypt(encrypted_message, decryption_mapping)
        display_message(encrypted_message, decrypted_message)

        user_input = input("\nEnter a substitution (e.g., 'a=b', 'x=y') or type 'exit' to finish: ").strip()

        if user_input.lower() == 'exit':
            break

        try:
            substitution_pair = user_input.split('=')
            encrypted_char, decrypted_char = substitution_pair[0].strip(), substitution_pair[1].strip()
            decryption_mapping[encrypted_char] = decrypted_char
        except (ValueError, IndexError):
            print("Invalid input. Please provide a valid substitution pair.")

    save_decrypted_message(decrypted_message, 'decrypted.txt')
    print("Decrypted message saved to 'decrypted.txt'.")

if __name__ == "__main__":
    main()
