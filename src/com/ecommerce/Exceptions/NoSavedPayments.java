package com.ecommerce.Exceptions;

public class NoSavedPayments extends Exception {
    public NoSavedPayments(String message) {
        super(message);
    }
}