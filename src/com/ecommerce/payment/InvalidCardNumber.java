package com.ecommerce.payment;

public class InvalidCardNumber extends Exception {
    public InvalidCardNumber(String message) {
        super(message);
    }
}