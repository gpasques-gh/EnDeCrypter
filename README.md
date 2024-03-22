# EnDeCrypter - A text encrypting command-line application & algorithm

**Author : @gpasques-gh**

**Disclaimer** : This project was made by someone which is a complete noob about anything cryptographic related. Any feedback would be appreciated.

## 1) How to use it ?
- Launching `Main` and following instructions
- Launching the `.jar` executable and following instructions
## 2) How does it work ?
- **2.a) Encryption with the `Encryption` class** 
  - This application generate an encryption key with random numbers
  - Each number is applied as Caesar cipher to each character from the input text file
  - The output file contains the unreadable text

- **2.b) Decryption with the `Decryption` class**
  - The algorithm will apply the stored encryption key to the input file and shift back each character to it's original position
  - The result will be stored in a text file contaning the plain text
## Thanks and have fun!