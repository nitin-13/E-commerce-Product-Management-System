package com.ecommerce;

import com.ecommerce.Exceptions.*;
import com.ecommerce.product.ClothingProduct;
import com.ecommerce.product.ElectronicProduct;
import com.ecommerce.product.KitchenWareProduct;
import com.ecommerce.product.Product;
import com.ecommerce.service.ShoppingService;
import com.ecommerce.customermanagement.Customer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CustomerNotFound, NoSavedPayments, ProductNotFound {

        Scanner in = new Scanner(System.in);

        ShoppingService shoppingService = new ShoppingService();
        String userName;
        String productId;
        String paymentType = "";

        //Create products
        Product mobile = new ElectronicProduct("E123", "iPhone 16 Pro", "Apple", 90000, "Built for Apple Intelligence", 12);
        Product tshirt = new ClothingProduct("C124", "Polo Tshirt", "Jockey", 500, "This is a Polo Tshirt", "Casual", "XL", "Cotton");
        Product nonStickPan = new KitchenWareProduct("K45", "Non-Stick Dosa Tawa", "Prestige", 3000, "Hard Anodised Non-Stick Cookware", "Cookware", "6-layer durable Stone finish non-stick coating");

        //Add products
        shoppingService.addProduct(mobile);
        shoppingService.addProduct(tshirt);
        shoppingService.addProduct(nonStickPan);

        //Display all products
        shoppingService.displayAllProducts();

        //Create customers
        Customer customer1 = new Customer("nitinshetye13", "shetye.nitin13@gmail.com", "Mapusa, 403507", "+91 9158926886");
        Customer customer2 = new Customer("shetyenitin13", "shetyenitin13@gmail.com", "Pernem, 403512", "+91 9158926886");
        Customer customer3 = new Customer("nitin.shetye13", "nitinshetye13@gmail.com", "Panaji, 403501", "+91 9158926886");

        //Add customers
        shoppingService.addCustomer(customer1);
        shoppingService.addCustomer(customer2);
        shoppingService.addCustomer(customer3);

        //Display all customers
        shoppingService.displayAllCustomers();


        System.out.print("Enter your username -> ");
        userName = in.nextLine();
        try {
            shoppingService.findCustomer(userName);
        } catch (CustomerNotFound e) {
            System.out.println(e.getMessage());
            in.close();
            return;
        }

        System.out.println("Welcome " + userName + " to Ecommerce App :\n");

        while (true) {
            System.out.println("1. View your orders");
            System.out.println("2. Display your details");
            System.out.println("3. View Saved Payment Methods");
            System.out.println("4. Add Payment methods to your account (Card / UPI)");
            System.out.println("5. Display All Products Available");
            System.out.println("6. Add Products to Cart");
            System.out.println("7. Remove Products from Cart");
            System.out.println("8. Display Cart");
            System.out.println("9. Checkout");
            System.out.println("10. Exit\n");
            System.out.print("Enter your choice -> ");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    shoppingService.displayCustomerOrders(userName);
                    break;

                case 2:
                    System.out.println("Your details are :");
                    shoppingService.displayCustomerDetails(userName);
                    break;

                case 3:
                    shoppingService.displayCustomerPayments(userName);
                    break;

                case 4:
                    System.out.println("1. Add Card Payment");
                    System.out.println("2. Add UPI Payment");
                    System.out.print("Enter your choice -> ");
                    int paymentChoice = in.nextInt();
                    in.nextLine();
                    switch (paymentChoice) {
                        case 1:
                            System.out.print("Enter Card Number -> ");
                            String cardNumber = in.nextLine();
                            System.out.print("Enter Expiry Date -> ");
                            String expiryDate = in.nextLine();
                            System.out.print("Enter CVV -> ");
                            int cvv = in.nextInt();
                            in.nextLine();
                            try {
                                shoppingService.addCardPayment(userName, cardNumber, expiryDate, cvv);
                            } catch (InvalidCardNumber e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 2:
                            System.out.print("Enter UPI ID -> ");
                            String upiId = in.nextLine();
                            try {
                                shoppingService.addUPIPayment(userName, upiId);
                            } catch (InvalidUPIID e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        default:
                            System.out.println("Invalid Choice. Please try again.");
                    }
                    break;

                case 5:
                    shoppingService.displayAllProducts();
                    break;

                case 6:
                    System.out.println("Below products are available, please select the product ID which you want to add to cart :");
                    shoppingService.displayAllProducts();
                    System.out.print("Enter Product ID -> ");
                    productId = in.nextLine();
                    try {
                        shoppingService.addProductToCart(userName, productId);
                    } catch (ProductNotFound e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 7:
                    System.out.println("Below products are in your cart, please select the product ID which you want to remove from cart :");
                    shoppingService.displayCart(userName);
                    System.out.print("Enter Product ID -> ");
                    productId = in.nextLine();
                    try {
                        shoppingService.removeProductFromCart(userName, productId);
                    } catch (ProductNotFound e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    break;

                case 8:
                    shoppingService.displayCart(userName);
                    break;

                case 9:
                    System.out.println("1. Card Payment");
                    System.out.println("2. UPI Payment");
                    System.out.print("Enter your choice -> ");
                    int paymentMethod = in.nextInt();
                    in.nextLine();
                    switch (paymentMethod) {
                        case 1:
                            paymentType = "card";
                            break;
                        case 2:
                            paymentType = "upi";
                            break;
                        default:
                            System.out.println("Invalid Choice. Please try again.");
                            break;
                    }
                    try {
                        shoppingService.checkout(userName, paymentType);
                    } catch (CustomerNotFound | NoSavedPayments e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 10:
                    System.out.println("Exiting...");
                    System.exit(0);
                    return;

            }

        }


    }
}