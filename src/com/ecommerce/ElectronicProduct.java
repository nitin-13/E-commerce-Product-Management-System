package com.ecommerce;

public class ElectronicProduct extends Product {//Inheritance
    private int warrantyMonths;

    ElectronicProduct(String name, String brand, double price, String description, int warrantyMonths) {
        super(name, brand, price, description);
        this.warrantyMonths = warrantyMonths;
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
        return "Electronic Product: " + getName() + ", Brand: " + getBrand() + ", Price: " + getPrice() + ", Warranty: " + getWarranty() + " Months.";
    }


}