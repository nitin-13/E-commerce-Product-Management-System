package com.ecommerce.service;


import com.ecommerce.ordermanagement.Order;
import com.ecommerce.product.Product;
import com.ecommerce.usermanagement.Customer;

import java.util.ArrayList;
import java.util.List;

public class ShoppingService {
    private List<Customer> customers;
    private List<Product> products;
    private Order order;

    public ShoppingService() {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }



    public void addProduct(Product product){
        products.add(product);
    }



    public Customer findCustomer(String userName){
        for(Customer customer : customers){
            if(customer.getUserName().equalsIgnoreCase(userName)){
                return customer;
            }
        }
        return null;
    }

    public Product findProduct(String productName){
        for(Product product : products){
            if(product.getProductName().equalsIgnoreCase(productName)){
                return product;
            }
        }
        return null;
    }

    public void addProductToCart(String userName, String productName){
        Customer customer = findCustomer(userName);
        Product product = findProduct(productName);
        if(customer != null && product != null){
            customer.addToCart(product);
        }
        else {
            System.out.println("Product not found");
        }
    }

    public void removeProductFromCart(String userName, String productName){
        Customer customer = findCustomer(userName);
        Product product = findProduct(productName);
        if(customer != null && product != null){
            customer.removeFromCart(product);
        }
        else {
            System.out.println("Product not found");
        }
    }

    //Display Methods

    public void displayCart(String userName){
        Customer customer = findCustomer(userName);
        if(customer != null){
            customer.displayCart();
        }
        else {
            System.out.println("Customer not found");
        }
    }

    public void displayAllCustomers(){
        System.out.println("Below are all the customers we have :");
        for(Customer customer : customers){
            System.out.println(customer);
        }
    }

    public void displayAllProducts(){
        System.out.println("Below are all the products we have :");
        for(Product product : products){
            System.out.println(product);
        }
    }



}