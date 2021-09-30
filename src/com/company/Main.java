package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String mode = "enc";
        int key = 0;
        String data = "";

        for (int i = 0; i < args.length; i += 2) {
            if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            } else if ("-mode".equals(args[i])) {
                mode = args[i + 1];
            } else if ("-data".equals(args[i])) {
                data = args[i + 1];
            }
        }

        if (("enc").equals(mode)) {
            String encrypted = Encryption.encrypt(data, key);
            System.out.println(encrypted);
        } else if (("dec").equals(mode)) {
            String message = Decryption.decrypt(data, key);
            System.out.println(message);
        }
    }
}
