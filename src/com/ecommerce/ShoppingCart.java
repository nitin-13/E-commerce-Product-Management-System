package com.ecommerce;

import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
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
        System.out.println("\nYour Cart Total : " + calculateCartTotal() + " Rupees. Thank You for shopping with us :)");
    }
}