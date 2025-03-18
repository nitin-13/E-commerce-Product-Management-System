package com.ecommerce;

import java.util.List;
import java.util.ArrayList;
import java.text.NumberFormat;

public class ShoppingCart implements Payment {
    NumberFormat formatCartTotal = NumberFormat.getInstance();
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    public double calculateCartTotal() {
        double cartTotal = 0;
        for (Product item : items) {
            cartTotal += item.getPrice();
        }
        return cartTotal;
    }

    public void displayShoppingCart() {
        System.out.println("Here is your shopping cart -> \n");
        for (Product item : items) {
            System.out.println(item.toString());
        }
        System.out.println("\nYour Cart Total : ₹" + formatCartTotal.format(calculateCartTotal()) + ". Thank You for shopping with us :)");
    }

    @Override
    public void payWithNetBanking() {
        System.out.println("Enter your net banking credentials");
    }

    @Override
    public void payWithCard(String cardNumber) throws InvalidCardNumber {
        //Add logic to check if cardNumber is only numeric

    }

    @Override
    public void payWithUPI() {
        System.out.println("pay with UPI");

    }
}