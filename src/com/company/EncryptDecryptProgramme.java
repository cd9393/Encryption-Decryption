package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncryptDecryptProgramme {
    private String mode = "enc";
    private String data = "";
    private int key = 0;
    private String inputFilePath = "";
    private String outputFilePath = "";

    public EncryptDecryptProgramme(String[] arguments) {
    parseArgs(arguments);
    }

    public  void run() {
        if ("".equals(data) && !"".equals(outputFilePath)) {
            setData(readFromFile(inputFilePath));
        }

        if (("enc").equals(getMode())) {
            encryptionMode(data,key,outputFilePath);
        } else if (("dec").equals(mode)) {
            decryptionMode(data,key,outputFilePath);
        }
    }

    private void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            if ("-key".equals(args[i])) {
                setKey(Integer.parseInt(args[i + 1]));
            } else if ("-mode".equals(args[i])) {
                setMode(args[i + 1]);
            } else if ("-data".equals(args[i])) {
                setData(args[i + 1]);
            } else if ("-in".equals(args[i])) {
                setInputFilePath(args[i + 1]);
            }else if ("-out".equals(args[i])) {
                setOutputFilePath(args[i + 1]);
            }
        }
    }

    private static String readFromFile(String in) {
        File file = new File(in);
        String fileContents = "";
        try (Scanner scanner = new Scanner(file)) {
            StringBuilder fileText = new StringBuilder();
            while(scanner.hasNext()) {
                fileText.append(scanner.nextLine());
            }
            fileContents = fileText.toString();

        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + in);
        }
        return fileContents;
    }

    private static void encryptionMode(String data, int key, String out) {
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
    }

    private static void decryptionMode(String data, int key, String output) {
        String message = Decryption.decrypt(data, key);
        if ("".equals(output)) {
            System.out.println(message);
        } else {
            File file = new File(output);
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(message);
            } catch (IOException e) {
                System.out.printf("An exception occurs %s", e.getMessage());
            }
        }
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }
}
