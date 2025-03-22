package com.ecommerce.cart;

import com.ecommerce.payment.InvalidCardNumber;

import com.ecommerce.product.Product;

import java.util.List;
import java.util.ArrayList;
import java.text.NumberFormat;

public class ShoppingCart {
    NumberFormat formatCartTotal = NumberFormat.getInstance();
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getName() + " has been added to your cart.");
    }

    public void removeItem(Product product) {
        if (items.remove(product)) {
            System.out.println(product.getName() + " has been removed from your cart.");
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
        System.out.println("Here is your shopping cart -> \n");
        for (Product item : items) {
            System.out.println(item.toString());
        }
        System.out.println("\nYour Cart Total : ₹" + formatCartTotal.format(calculateCartTotal()) + ". Thank You for shopping with us :)");
    }


}