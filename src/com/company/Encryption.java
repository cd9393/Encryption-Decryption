package com.company;

public class Encryption {
    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String encrypt(String message) {
        char[] messageArray = message.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : messageArray) {
            if (c >= 97 && c <= 122) {
                result.append(alphabet[Math.abs(c - 122)]);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
