package com.company;

abstract class Cipher {
    abstract String encrypt(String message, int key);

    abstract String decrypt(String message, int key);
}
