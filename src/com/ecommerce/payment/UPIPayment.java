package com.ecommerce.payment;

public class UPIPayment extends Payment {

    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void processPayment(double totalAmount) {

        System.out.println("Paid ₹ " + totalAmount + " using UPI ID " + upiId);


    }
}