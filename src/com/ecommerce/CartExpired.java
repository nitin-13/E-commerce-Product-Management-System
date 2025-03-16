package com.ecommerce;

public class CartExpired extends Exception {
    public CartExpired(String message) {
        super(message);
    }
}