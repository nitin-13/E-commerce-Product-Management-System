package com.ecommerce.ordermanagement;

import com.ecommerce.cart.Cart;
import com.ecommerce.payment.InvalidCardNumber;
import com.ecommerce.payment.Payment;
import com.ecommerce.usermanagement.Customer;

public class Order {
    private int orderNumber;
    private Customer customer;
    private Cart cart;

    public Order(Customer customer, Cart cart) {
        this.orderNumber = OrderNumberGenerator.generateOrderNumber();
        this.customer = customer;
        this.cart = cart;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void placeOrder(Payment paymentMethod) throws InvalidCardNumber {
        System.out.println("\nOrder ID: " + getOrderNumber());
        System.out.println("Customer: " + customer.getUserName());
        System.out.println("Shipping Address: " + customer.getAddress());
        System.out.println("Total Amount: " + cart.calculateCartTotal());
        paymentMethod.processPayment(cart.calculateCartTotal());
        System.out.println("Order placed successfully!");
        customer.addOrder(this);
    }
}