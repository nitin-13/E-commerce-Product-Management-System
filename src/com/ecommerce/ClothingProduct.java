package com.ecommerce;

public class ClothingProduct extends Product {
    private String type; //daily_casual_office
    private String size;
    private String material;

    ClothingProduct(String name, String brand, double price, String description, String type, String size, String material) {
        super(name, brand, price, description);
        this.type = type;
        this.size = size;
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String getProductType() {
        return "Clothing";
    }

    @Override
    public String toString() {
        return "Clothing Product: " + getName() + ", Brand: " + getBrand() + ", Price: " + getPrice() + ",Type: " + getType() + " Size: " + getSize() + ", Material: " + getMaterial() + ".";
    }

}