package com.company;

public class UnicodeEncryption extends Encryption {

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
}
