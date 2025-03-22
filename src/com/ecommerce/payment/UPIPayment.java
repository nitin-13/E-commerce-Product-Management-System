package com.ecommerce.payment;

public class UPIPayment extends Payment{

    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void processPayment(double totalAmount) throws InvalidUPIID {
        String bankName = upiId.substring(upiId.indexOf('@') + 1);
        if (bankName.equalsIgnoreCase("okhdfcbank") || bankName.equalsIgnoreCase("okaxisbank") || bankName.equalsIgnoreCase("oksbi") || bankName.equalsIgnoreCase("okicici") || bankName.equalsIgnoreCase("okkotak") || bankName.equalsIgnoreCase("okidfc")) {
            throw new InvalidUPIID("Error: Payment Failed, Invalid UPI ID");
        } else {
            System.out.println("Paid ₹ " + totalAmount + " using UPI ID " + upiId);
        }

    }
}