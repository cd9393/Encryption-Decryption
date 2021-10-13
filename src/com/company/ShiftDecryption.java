package com.company;

public class ShiftDecryption extends Decryption {

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
