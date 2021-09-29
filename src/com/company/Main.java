package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        String encryptionOrDecryption = scanner.nextLine();

        if (encryptionOrDecryption.equals("enc")) {
            String originalText = scanner.nextLine();
            Integer key = scanner.nextInt();
            String encrypted = Encryption.encrypt(originalText, key);
            System.out.println(encrypted);
        } else if (encryptionOrDecryption.equals("dec")) {
            String cypherText = scanner.nextLine();
            int key = scanner.nextInt();
            String message = Decryption.decrypt(cypherText, key);
            System.out.println(message);
        }
    }
}
