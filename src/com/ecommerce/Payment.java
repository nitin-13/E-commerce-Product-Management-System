package com.ecommerce;

public interface Payment {
    public void payWithNetBanking();

    public void payWithCard(String cardNumber) throws InvalidCardNumber;

    public void payWithUPI();
}