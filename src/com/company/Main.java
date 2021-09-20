package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String message = "we found a treasure!";
        String encrypted = Encryption.encrypt(message);
        System.out.println(encrypted);
    }
}
