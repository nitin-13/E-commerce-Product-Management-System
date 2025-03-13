package com.ecommerce;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is an E-commerce Product Management System");

        ShoppingCart cart = new ShoppingCart();

        Product mobile = new ElectronicProduct("iPhone 16 Pro", 90000, "Built for Apple Intelligence", "Apple", 12);
        Product tshirt = new ClothingProduct("Polo Tshirt", 500, "This is a Polo Tshirt", "Casual", "XL", "Cotton");

        cart.addItem(mobile);
        cart.addItem(tshirt);

        cart.displayShoppingCart();
    }
}