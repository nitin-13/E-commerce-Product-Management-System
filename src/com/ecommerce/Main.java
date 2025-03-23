package com.ecommerce;

import com.ecommerce.cart.Cart;
import com.ecommerce.ordermanagement.Order;
import com.ecommerce.payment.CardPayment;
import com.ecommerce.payment.InvalidCardNumber;
import com.ecommerce.payment.Payment;
import com.ecommerce.product.ClothingProduct;
import com.ecommerce.product.ElectronicProduct;
import com.ecommerce.product.KitchenWareProduct;
import com.ecommerce.product.Product;
import com.ecommerce.service.ShoppingService;
import com.ecommerce.usermanagement.Customer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Ecommerce Platform\n");

        ShoppingService shoppingService = new ShoppingService();

        Product mobile = new ElectronicProduct("iPhone 16 Pro", "Apple", 90000, "Built for Apple Intelligence", 12);
        Product tshirt = new ClothingProduct("Polo Tshirt", "Jockey", 500, "This is a Polo Tshirt", "Casual", "XL", "Cotton");
        Product nonStickPan = new KitchenWareProduct("Non-Stick Dosa Tawa", "Prestige", 3000, "Hard Anodised Non-Stick Cookware", "Cookware", "6-layer durable Stone finish non-stick coating");

        Customer customer1 = new Customer("nitinshetye13", "shetye.nitin13@gmail.com", "Mapusa, 403507", "+91 9158926886");
        Customer customer2 = new Customer("shetyenitin13", "shetyenitin13@gmail.com", "Pernem, 403512", "+91 9158926886");
        Customer customer3 = new Customer("nitin.shetye13", "nitinshetye13@gmail.com", "Panaji, 403501", "+91 9158926886");

        //Add products to the shopping service
        shoppingService.addProduct(mobile);
        shoppingService.addProduct(tshirt);
        shoppingService.addProduct(nonStickPan);

        //Display all products
        shoppingService.displayAllProducts();

        //Add customers to the shopping service
        shoppingService.addCustomer(customer1);
        shoppingService.addCustomer(customer2);
        shoppingService.addCustomer(customer3);

        //Display all customers
        shoppingService.displayAllCustomers();

        shoppingService.addProductToCart("nitinshetye13", "iPhone 16 Pro");
        shoppingService.addProductToCart("nitinshetye13", "Polo Tshirt");
        shoppingService.displayCart("nitinshetye13");

        shoppingService.removeProductFromCart("nitinshetye13", "iPhone 16 Pro");







    }
}