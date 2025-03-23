package com.ecommerce.Exceptions;

public class InvalidCardNumber extends Exception {
    public InvalidCardNumber(String message) {
        super(message);
    }
}