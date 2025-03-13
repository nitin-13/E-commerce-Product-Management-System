package com.ecommerce;

public class ElectronicProduct extends Product {//Inheritance
    private String brand;
    private int warrantyMonths;

    ElectronicProduct(String name, double price, String description, String brand, int warrantyMonths) {
        super(name, price, description);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand() {
        return brand;
    }

    public int getWarranty() {
        return warrantyMonths;
    }

    @Override
    public String getProductType() {
        return "Electronics";
    }

    @Override
    public String toString() {
        return "Electronic Product: " + getName() + ", Price: " + getPrice() + ", Brand: " + getBrand() + ", Warranty: " + getWarranty() + " Months.";
    }


}