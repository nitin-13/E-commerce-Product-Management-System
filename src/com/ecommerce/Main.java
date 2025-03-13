package com.ecommerce;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is an E-commerce Product Management System\n");

        ShoppingCart cart = new ShoppingCart();

        Product mobile = new ElectronicProduct("iPhone 16 Pro", "Apple", 90000, "Built for Apple Intelligence", 12);
        Product tshirt = new ClothingProduct("Polo Tshirt", "Jockey", 500, "This is a Polo Tshirt", "Casual", "XL", "Cotton");
        Product nonStickPan = new KitchenWareProduct("Non-Stick Dosa Tawa", "Prestige", 3000, "Hard Anodised Non-Stick Cookware", "Cookware", "6-layer durable Stone finish non-stick coating");

        cart.addItem(mobile);
        cart.addItem(tshirt);
        cart.addItem(nonStickPan);

        cart.displayShoppingCart();
    }
}