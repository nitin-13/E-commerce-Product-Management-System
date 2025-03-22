package com.ecommerce.payment;

public class CardPayment extends Payment {
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private int cvv;

    public CardPayment(String cardNumber, String cardHolder, String expiryDate, int cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void processPayment(double totalAmount) throws InvalidCardNumber {
        if (cardNumber.length() != 16) {
            throw new InvalidCardNumber("Error: Payment Failed, Invalid card number");
        } else {
            System.out.println("Paid ₹ " + totalAmount + " using card ending with " + cardNumber.substring(12));

        }

    }
}