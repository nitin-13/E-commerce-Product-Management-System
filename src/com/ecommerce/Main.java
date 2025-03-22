package com.ecommerce;

import com.ecommerce.cart.ShoppingCart;
import com.ecommerce.ordermanagement.Order;
import com.ecommerce.payment.CardPayment;
import com.ecommerce.payment.Payment;
import com.ecommerce.product.ClothingProduct;
import com.ecommerce.product.ElectronicProduct;
import com.ecommerce.product.KitchenWareProduct;
import com.ecommerce.product.Product;
import com.ecommerce.usermanagement.Customer;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is an E-commerce Product Management System\n");

        Product mobile = new ElectronicProduct("iPhone 16 Pro", "Apple", 90000, "Built for Apple Intelligence", 12);
        Product tshirt = new ClothingProduct("Polo Tshirt", "Jockey", 500, "This is a Polo Tshirt", "Casual", "XL", "Cotton");
        Product nonStickPan = new KitchenWareProduct("Non-Stick Dosa Tawa", "Prestige", 3000, "Hard Anodised Non-Stick Cookware", "Cookware", "6-layer durable Stone finish non-stick coating");

        Customer customer1 = new Customer("nitinshetye13", "shetye.nitin13@gmail.com", "Mapusa, 403507", "+91 9158926886");
        Customer customer2 = new Customer("shetyenitin13", "shetyenitin13@gmail.com", "Pernem, 403512", "+91 9158926886");
        Customer customer3 = new Customer("nitin.shetye13", "nitinshetye13@gmail.com", "Panaji, 403501", "+91 9158926886");

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(mobile);
        cart.addItem(tshirt);
        cart.addItem(nonStickPan);

        cart.displayShoppingCart();

        Order order = new Order(customer1, cart);

        Payment debitCard = new CardPayment("1234567890123456", "Nitin", "12/23", 123);

        try {
            order.placeOrder(debitCard);
        } catch (Exception e) {
            System.out.println("Payment failed. Please try again.");
        }

    }
}