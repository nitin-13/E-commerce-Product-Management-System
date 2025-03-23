package com.ecommerce.usermanagement;

import com.ecommerce.cart.Cart;
import com.ecommerce.ordermanagement.Order;
import com.ecommerce.payment.Payment;
import com.ecommerce.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String shippingAddress;
    private String phone;
    private List<Order> orders;
    private List<Payment> paymentMethods;
    private Cart cart;


    public Customer(String userName, String email, String shippingAddress, String phone) {
        super(userName, email);
        this.shippingAddress = shippingAddress;
        this.phone = phone;
        this.orders = new ArrayList<>();
        this.paymentMethods = new ArrayList<>();
        this.cart = new Cart();

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

}