package com.company;

public class CipherFactory {
    public Cipher createEncryption(String type) {
        if ("shift".equals(type)) {
            return new ShiftCipher();
        } else if ("unicode".equals(type)) {
            return new UnicodeCipher();
        }
        System.out.println("we don't currently support this kind of encryption");
        return null;
    }
}
