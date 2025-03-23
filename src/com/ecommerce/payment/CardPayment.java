package com.ecommerce.payment;

public class CardPayment extends Payment {
    private String cardNumber;
    private String expiryDate;
    private int cvv;

    public CardPayment(String cardNumber, String expiryDate, int cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return "************" + cardNumber.substring(12);
    }

    @Override
    public void processPayment(double totalAmount) {
        System.out.println("Paid ₹ " + totalAmount + " using card ending with " + cardNumber.substring(12));
    }
}