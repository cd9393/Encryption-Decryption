package com.company;

public class DecryptionFactory {
    public Decryption returnDecryption(String type) {
        if ("shift".equals(type)) {
            return new ShiftDecryption();
        } else if ("unicode".equals(type)) {
            return new UniCodeDecryption();
        }
        System.out.println("we don't currently support this kind of decryption");
        return null;
    }
}
