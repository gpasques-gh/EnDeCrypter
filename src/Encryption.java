import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Encryption {

    /***
     * startEncryption method
     * @param inputFile the text file that will be encrypted
     * @param outputFile the text file where the encrypted text will go
     * @param keyPath the path to the decryption key that will be generated
     * @throws Exception any exception
     */
    public static void startEncryption(String inputFile, String outputFile, String keyPath) throws Exception {

        // Opening streams
        FileReader fileReader = new FileReader(inputFile); // Input file
        FileWriter fileWriter = new FileWriter(outputFile); // Output file
        FileOutputStream key = new FileOutputStream(keyPath); // Encryption key file

        int c = fileReader.read(); // Getting the first character
        int shift; // Instancing the shift that will be made on the letters

        // Looping on the FileReader
        while (c != -1) {
            System.out.println(c);
            shift = (int)(27 * Math.random()); // Getting a random number between 0-26
            key.write(shift); // Writing the number on the encryption key
            fileWriter.write(encryptChar(c, shift)); // Writing the encrypted character on the output file
            c = fileReader.read(); // Getting the next character
        }

        // Closing streams
        fileReader.close();
        fileWriter.close();
        key.close();
    }

    /***
     * encryptChar method
     * @param c the character to be encrypted
     * @param shift the shift to be made on the character
     * @return the encrypted character
     */
    public static int encryptChar(int c, int shift) {
        int index = -1; // The index of the character in the alphabet
        // If the character is uppercase
        if (Character.isUpperCase(c)) {
            c = Character.toLowerCase(c);
        }
        // Getting the alphabet with ASCII characters
        int[] alphabet = new int[27];
        for (int i = 0; i < 27; i++) {
            if (i == 0) alphabet[i] = 32;
            else alphabet[i] = 97 + i;
            if (alphabet[i] == c) {
                index = i;
            }
        }
        // If the character is not in the alphabet (e.g a number, a comma...)
        if (index == -1) {
            return c; // Return the character without encrypting it
        }

        // Return the shifted/encrypted character
        return alphabet[(index + shift) % alphabet.length];
    }

}
