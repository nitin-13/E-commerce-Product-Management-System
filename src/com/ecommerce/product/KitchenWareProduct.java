package com.ecommerce.product;

public class KitchenWareProduct extends Product {
    private String type;
    private String features;

    public KitchenWareProduct(String productId, String name, String brand, double price, String description, String type, String features) {
        super(productId, name, brand, price, description);
        this.type = type;
        this.features = features;
    }

    public String getType() {
        return type;
    }

    public String getFeatures() {
        return features;
    }

    @Override
    public String getProductType() {
        return "Kitchen Ware";
    }

    @Override
    public String toString() {
        return "Kitchen Ware Product: Product Id: " + getProductId() +
                ", Name: " + getProductName() +
                ", Brand: " + getBrand() +
                ", Price: ₹" + formatPrice.format(getPrice()) +
                ", Type: " + getType() +
                ", Features: " + getFeatures();
    }
}