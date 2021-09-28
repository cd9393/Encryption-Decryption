package com.company;

public class Encryption {
    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String encrypt(String message, int key) {
        char[] messageArray = message.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : messageArray) {
            if (c >= 97 && c <= 122) {
                int charPosition = c - 97;
                result.append(alphabet[(charPosition + key) % 26]);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
