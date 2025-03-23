package com.ecommerce.cart;

import com.ecommerce.product.Product;

import java.util.List;
import java.util.ArrayList;
import java.text.NumberFormat;

public class Cart {
    NumberFormat formatCartTotal = NumberFormat.getInstance();
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getProductName() + " has been added to your cart.");
    }

    public void removeItem(Product product) {
        if (items.remove(product)) {
            System.out.println(product.getProductName() + " has been removed from your cart.");
        } else {
            System.out.println("The product you are trying to remove is not in your cart.");
        }
    }

    public double calculateCartTotal() {
        double cartTotal = 0;
        for (Product item : items) {
            cartTotal += item.getPrice();
        }
        return cartTotal;
    }

    public void displayShoppingCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        }
            else {
            System.out.println("Your cart contains:");
                for (Product item : items) {
                System.out.println(item.toString());
            }
        }
    }


}