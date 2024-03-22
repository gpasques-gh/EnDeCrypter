import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Decryption {

    /***
     * startDecryption method
     * @param fileInput the file to be decrypted
     * @param fileOutput the file where the decrypted text will go
     * @param key the decryption key
     * @throws Exception any exception
     */
    public static void startDecryption(String fileInput, String fileOutput, String key) throws Exception {
        // Opening streams
        FileReader fileReader = new FileReader(fileInput); // Input file
        FileWriter fileWriter = new FileWriter(fileOutput); // Output file
        FileInputStream keyStream = new FileInputStream(key); // Decryption key file

        int c = fileReader.read(); // Getting the first character
        int shift; // Instancing the shift to be applied to each character

        // Looping on the input file
        while (c != -1) {
            shift = keyStream.read(); // Read the encryption shift
            fileWriter.write(decryptChar(c, shift)); // Write the decrypted character to the output file
            c = fileReader.read(); // Get the next character
        }

        // Closing streams
        fileReader.close();
        fileWriter.close();
        keyStream.close();
    }

    /***
     * decryptChar method
     * @param c the character to be decrypted
     * @param shift the shift to be applied to the character
     * @return the decrypted character
     */
    public static int decryptChar(int c, int shift) {
        int index = -1; // The index of the character in the alphabet
        // If the character is uppercase
        if (Character.isUpperCase(c)) {
            c = Character.toLowerCase(c);
        }
        // Getting the alphabet with ASCII characters
        int[] alphabet = new int[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = 97 + i;
            if (alphabet[i] == c) {
                index = i;
            }
        }
        // If the character is not in the alphabet (e.g a number, a comma...)
        if (index == -1) {
            return c; // Return the character without decrypting it
        }

        System.out.println(shift + " shift");
        System.out.println(index + " index");

        // Making the shift get back to the end of the alphabet if it's below 0
        while (index - shift < 0) {
            shift -= alphabet.length;
        }
        // Return the shifted/decrypted character
        return alphabet[index - shift];
    }
}
