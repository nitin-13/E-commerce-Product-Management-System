package com.ecommerce.payment;

public abstract class Payment {
    public abstract void processPayment(double totalAmount) throws InvalidCardNumber, InvalidUPIID;
}