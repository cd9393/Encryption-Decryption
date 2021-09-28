package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        String message = "we found a treasure!";
        Scanner scanner = new Scanner(System.in);
        String originalText = scanner.nextLine();
        Integer key = scanner.nextInt();
        String encrypted = Encryption.encrypt(originalText, key);
        System.out.println(encrypted);
    }
}
