package com.company;

public class UniCodeDecryption extends Decryption {
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
