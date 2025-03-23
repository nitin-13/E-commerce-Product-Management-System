package com.ecommerce.customermanagement;

import com.ecommerce.Exceptions.InvalidCardNumber;
import com.ecommerce.Exceptions.InvalidUPIID;
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
    private CardPayment cardPayment;
    private UPIPayment upiPayment;
    private Cart cart;


    public Customer(String userName, String email, String shippingAddress, String phone) {
        this.userName = userName;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.phone = phone;
        this.orders = new ArrayList<>();
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

    public void addToCart(Product product) {
        this.cart.addItem(product);

    }

    public void removeFromCart(Product product) {
        this.cart.removeItem(product);
    }

    public void displayCart() {
        this.cart.displayShoppingCart();
    }

    public Cart getCart() {
        return cart;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void getMyOrders() {
        if (orders.isEmpty()) {
            System.out.println("You have no orders");
        } else {
            System.out.println("Here are your orders : ");
            for (Order order : orders) {
                System.out.println(order.getOrderNumber());
            }
        }
    }

    @Override
    public String toString() {
        return "Username = " + getUserName() + " Email = " + getEmail() + " Phone = " + phone;
    }

    public void addCardPayment(String cardNumber, String expiryDate, int cvv) throws InvalidCardNumber {
        if (cardNumber.length() != 16) {
            throw new InvalidCardNumber("Error: Payment Failed, Invalid card number");
        } else {
            cardPayment = new CardPayment(cardNumber, expiryDate, cvv);
            System.out.println("Card ending with " + cardNumber.substring(12) + " added successfully");
        }
    }

    public void addUPIPayment(String upiId) throws InvalidUPIID {
        String bankName = upiId.substring(upiId.indexOf('@') + 1);
        if (bankName.equalsIgnoreCase("okhdfcbank") || bankName.equalsIgnoreCase("okaxisbank") || bankName.equalsIgnoreCase("oksbi") || bankName.equalsIgnoreCase("okicici") || bankName.equalsIgnoreCase("okkotak") || bankName.equalsIgnoreCase("okidfc")) {
            upiPayment = new UPIPayment(upiId);
            System.out.println("UPI ID " + upiId + " added successfully");
        } else {
            throw new InvalidUPIID("Error: Payment Failed, Invalid UPI ID");
        }
    }

    public Payment getCard() {
        return cardPayment;
    }

    public Payment getUPI() {
        return upiPayment;
    }

    public void displaySavedPayments(){
        System.out.println(" Your Saved Payment Methods : ");
        if(cardPayment != null){
            System.out.println("Card ending with "+cardPayment.getCardNumber());
        }
        if(upiPayment != null){
            System.out.println("UPI ID "+upiPayment.getUpiId());
        }

    }

    public void clearCart() {
        cart.clearCart();
    }


}