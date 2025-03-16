package com.ecommerce;

public interface Payment {
    public void payWithNetBanking();

    public void payWithCard(int cardNumber, String date, int cvv);

    public void payWithUPI();
}