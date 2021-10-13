package com.company;

public class EncryptionFactory {
    public Encryption createEncryption(String type) {
        if ("shift".equals(type)) {
            return new ShiftEncryption();
        } else if ("unicode".equals(type)) {
            return new UnicodeEncryption();
        }
        System.out.println("we don't currently support this kind of encryption");
        return null;
    }
}
