package com.ecommerce.product;

import java.text.NumberFormat;

public abstract class Product { //Base Class and Provides Abstraction
    private String productId;
    private String name;
    private String brand;
    private double price;
    private String description;

    NumberFormat formatPrice = NumberFormat.getInstance();

    public Product(String productId, String name, String brand, double price, String description) {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract String getProductType();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}