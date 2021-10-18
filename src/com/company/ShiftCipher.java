package com.company;

public class ShiftCipher extends Cipher {
    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Override
    public String encrypt(String message, int key) {
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

    @Override
    public String decrypt(String message, int key) {
        char[] messageArray = message.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : messageArray) {
            if ((c >= 97 && c <= 122 ) || (c >= 65 && c <= 90)) {
                int charPosition = c - 97;
                int newAlphabetPosition = (charPosition + (26 - (key % 26))) % 26;
                char newChar = (char) ('a' + newAlphabetPosition);
                result.append(newChar);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
