package com.ecommerce.customermanagement;

import com.ecommerce.cart.Cart;
import com.ecommerce.ordermanagement.Order;
import com.ecommerce.payment.*;
import com.ecommerce.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String userName;
    private String email;
    private String shippingAddress;
    private String phone;
    private List<Order> orders;
    private List<Payment> paymentMethods;
    private Cart cart;


    public Customer(String userName, String email, String shippingAddress, String phone) {
        this.userName = userName;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.phone = phone;
        this.orders = new ArrayList<>();
        this.paymentMethods = new ArrayList<>();
        this.cart = new Cart();

    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return shippingAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void addToCart(Product product){
        this.cart.addItem(product);

    }

    public void removeFromCart(Product product){
        this.cart.removeItem(product);
    }

    public void displayCart(){
        this.cart.displayShoppingCart();
    }

    public Cart getCart(){
        return cart;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void getMyOrders(){
        if (orders.isEmpty()) {
            System.out.println("You have no orders");
        }
        for(Order order : orders){
            System.out.println(order.getOrderNumber());
        }
    }

    @Override
    public String toString() {
        return "Username =" + getUserName() + " Email =" + getEmail() + " Phone=" + phone;
    }

    public void addCardPayment(String cardNumber, String expiryDate , int cvv) throws InvalidCardNumber {
        if (cardNumber.length() != 16) {
            throw new InvalidCardNumber("Error: Payment Failed, Invalid card number");
        } else {
            paymentMethods.add(new CardPayment(cardNumber, expiryDate, cvv));
            System.out.println("Card ending with "+ cardNumber.substring(12)+" added successfully");
        }
    }

    public void addUPIPayment(String upiId) throws InvalidUPIID {
        String bankName = upiId.substring(upiId.indexOf('@') + 1);
        if (bankName.equalsIgnoreCase("okhdfcbank") || bankName.equalsIgnoreCase("okaxisbank") || bankName.equalsIgnoreCase("oksbi") || bankName.equalsIgnoreCase("okicici") || bankName.equalsIgnoreCase("okkotak") || bankName.equalsIgnoreCase("okidfc")) {
            throw new InvalidUPIID("Error: Payment Failed, Invalid UPI ID");
        } else {
            paymentMethods.add(new UPIPayment(upiId));
            System.out.println("UPI ID "+upiId+"added successfully");
        }
    }

    public Payment getPaymentMethod() {
        return paymentMethods.get(0);
    }


}