package com.ecommerce.usermanagement;

import com.ecommerce.cart.ShoppingCart;

public class Customer extends User {
    private String shippingAddress;
    private String phone;


    public Customer(String userName, String email, String shippingAddress, String phone) {
        super(userName, email);
        this.shippingAddress = shippingAddress;
        this.phone = phone;

    }

    public String getAddress() {
        return shippingAddress;
    }

    public String getPhone() {
        return phone;
    }
}