package com.company;

public class UnicodeCipher extends Cipher {

    @Override
    public String encrypt(String message, int key) {
        char[] messageArray = message.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : messageArray) {
            int charPosition = c + key;
            result.append(Character.toChars(charPosition));
        }
        return result.toString();
    }

    @Override
    public String decrypt(String cypherText, int key) {
        char[] cypherTextArray = cypherText.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : cypherTextArray) {
            int charPosition = c - key;
            result.append(Character.toChars(charPosition));
        }
        return result.toString();
    }
}
