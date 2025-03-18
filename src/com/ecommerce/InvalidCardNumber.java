package com.ecommerce;

public class InvalidCardNumber extends Exception {
    public InvalidCardNumber(String message) {
        super(message);
    }
}