package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String mode = "enc";
        int key = 0;
        String data = "";
        String in = "";
        String out = "";

        for (int i = 0; i < args.length; i += 2) {
            if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            } else if ("-mode".equals(args[i])) {
                mode = args[i + 1];
            } else if ("-data".equals(args[i])) {
                data = args[i + 1];
            } else if ("-in".equals(args[i])) {
                in = args[i + 1];
            }else if ("-out".equals(args[i])) {
                out = args[i + 1];
            }
        }

        if ("".equals(data) && !"".equals(in)) {
            File file = new File(in);
            try (Scanner scanner = new Scanner(file)) {
                StringBuilder fileText = new StringBuilder();
                while(scanner.hasNext()) {
                    fileText.append(scanner.nextLine());
                }
                data = fileText.toString();

            } catch (FileNotFoundException e) {
                System.out.println("No file found: " + in);
            }
        }

        if (("enc").equals(mode)) {
            String encrypted = Encryption.encrypt(data, key);
            if ("".equals(out)) {
                System.out.println(encrypted);
            } else {
                File file = new File(out);
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(encrypted);
                } catch (IOException e) {
                    System.out.printf("An exception occurs %s", e.getMessage());
                }
            }
        } else if (("dec").equals(mode)) {
            String message = Decryption.decrypt(data, key);
            if ("".equals(out)) {
                System.out.println(message);
            } else {
                File file = new File(out);
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(message);
                } catch (IOException e) {
                    System.out.printf("An exception occurs %s", e.getMessage());
                }
            }
        }
    }
}
