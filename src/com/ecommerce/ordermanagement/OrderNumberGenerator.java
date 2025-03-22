package com.ecommerce.ordermanagement;

import java.util.Random;

public class OrderNumberGenerator {
    public static int generateOrderNumber() {
        Random random = new Random();
        int orderNumber = 100000 + random.nextInt(900000); // Generates a random 6-digit number
        return orderNumber;
    }
}