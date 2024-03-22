import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        // Scanner
        Scanner sc = new Scanner(System.in);

        // Visuals
        System.out.println("#    ______       _____        _____                  _            ");
        System.out.println("#   |  ____|     |  __ \\      / ____|                | |           ");
        System.out.println("#   | |__   _ __ | |  | | ___| |     _ __ _   _ _ __ | |_ ___ _ __");
        System.out.println("#   |  __| | '_ \\| |  | |/ _ \\ |    | '__| | | | '_ \\| __/ _ \\ '__|");
        System.out.println("#   | |____| | | | |__| |  __/ |____| |  | |_| | |_) | ||  __/ |   ");
        System.out.println("#   |______|_| |_|_____/ \\___|\\_____|_|   \\__, | .__/ \\__\\___|_|   ");
        System.out.println("#                                          __/ | |                 ");
        System.out.println("#                                         |___/|_|                 \n");

        System.out.println("# Do you want to encrypt a text file (E) or decrypt a text file (D) ?");

        // Variables
        String userInput = sc.nextLine();
        String fileInput;
        String fileOutput;
        String keyPath;

        // Boolean to check if the program is done
        boolean done = false;

        // Loop
        while (!done) {
            // Try/Catch
            try {
                // Checking the first user input
                switch (userInput) {
                    case ("E"): // Encrypting file
                        System.out.println("# Please enter the name of the file that will be encrypted :");
                        fileInput = sc.nextLine(); // Getting the input file path
                        if (!Files.exists(Paths.get(fileInput)) || fileInput.isBlank()) // Throwing an exception if the path is invalid
                            throw new FileNotFoundException("# Invalid path for encrypting input file : '" + fileInput + "'");
                        System.out.println("# Please enter the name of the output file (the file where the encrypted text will be stored) :");
                        fileOutput = sc.nextLine(); // Getting the output file path
                        System.out.println("# Please enter the name of the decryption key :");
                        keyPath = sc.nextLine(); // Getting the encryption key file path
                        Encryption.startEncryption(fileInput, fileOutput, keyPath); // Starting encryption
                        System.out.println("# The file " + fileInput + " has been encrypted in " + fileOutput + " using the " + keyPath + " encryption key.");
                        done = true; // Program is done
                        break;
                    case ("D"): // Decrypting file
                        System.out.println("# Please enter the name of the file that will be decrypted :");
                        fileInput = sc.nextLine(); // Getting the input file path
                        if (!Files.exists(Paths.get(fileInput)) || fileInput.isBlank()) // Throwing an exception if the path is invalid
                            throw new FileNotFoundException("# Invalid path for decrypting input file : '" + fileInput + "'");
                        System.out.println("# Please enter the name of the output file (the file where the decrypted text will be stored) :");
                        fileOutput = sc.nextLine(); // Getting the output file path
                        System.out.println("# Please enter the path for the decryption key :");
                        keyPath = sc.nextLine(); // Getting the decrypting key file path
                        if (!Files.exists(Paths.get(keyPath)) || keyPath.isBlank()) // Throwing an exception if the key file path is invalid
                            throw new FileNotFoundException("# Invalid path for decrypting key file : '" + keyPath + "'");
                        Decryption.startDecryption(fileInput, fileOutput, keyPath); // Starting the decryption
                        System.out.println("# The file " + fileInput + " has been decrypted in " + fileOutput + " using the " + keyPath + " decryption key.");
                        done = true; // Program is done
                        break;
                    default: // If the user entered something else than 'E' or 'D'
                        System.out.println("# Please enter either 'E' (for encryption) or 'D' (for decryption).");
                        System.out.println("# Enter again :");
                        userInput = sc.nextLine(); // Getting the user input again
                        break;
                }
            } catch (FileNotFoundException e) { // Catching a FileNotFoundException
                System.out.println(e.getMessage()); // Printing the message
            }
        }
    }
}
