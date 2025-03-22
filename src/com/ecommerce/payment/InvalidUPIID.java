package com.ecommerce.payment;

public class InvalidUPIID extends Exception {
    public InvalidUPIID(String message) {
        super(message);
    }
}