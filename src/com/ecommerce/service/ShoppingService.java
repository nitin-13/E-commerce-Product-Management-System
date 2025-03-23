package com.ecommerce.service;


import com.ecommerce.Exceptions.*;
import com.ecommerce.ordermanagement.Order;
import com.ecommerce.payment.*;
import com.ecommerce.product.Product;
import com.ecommerce.customermanagement.Customer;

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

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Customer findCustomer(String userName) throws CustomerNotFound {
        for (Customer customer : customers) {
            if (customer.getUserName().equalsIgnoreCase(userName)) {
                return customer;
            } else {
                throw new CustomerNotFound("ERROR : Customer Not Found");
            }
        }
        return null;
    }

    public Product findProduct(String productId) throws ProductNotFound {
        System.out.println(productId);
        for (Product product : products) {
            if (product.getProductId().equalsIgnoreCase(productId)) {
                return product;
            }
            else {
                throw new ProductNotFound("ERROR : Product Not Found");
            }
        }
        return null;
    }

    public Payment getPaymentMethod(String userName, String paymentMethod) throws CustomerNotFound {
        Customer customer = findCustomer(userName);
        if (customer != null) {
            if (paymentMethod.equalsIgnoreCase("card")) {
                return customer.getCard();
            } else if (paymentMethod.equalsIgnoreCase("upi")) {
                return customer.getUPI();
            }
            else {
                throw new CustomerNotFound("ERROR : Customer Not Found");
            }
        }
        return null;
    }

    public void addProductToCart(String userName, String productId) throws CustomerNotFound, ProductNotFound {
        Customer customer = findCustomer(userName);
        Product product = findProduct(productId);
        System.out.println("Inside addProductToCart Method : "+product);
        if (customer != null && product != null) {
            customer.addToCart(product);
        } else {
            throw new ProductNotFound("ERROR : Product Not Found");
        }
    }

    public void removeProductFromCart(String userName, String productId) throws CustomerNotFound, ProductNotFound {
        Customer customer = findCustomer(userName);
        Product product = findProduct(productId);
        if (customer != null && product != null) {
            customer.removeFromCart(product);
        } else {
            System.out.println("ERROR : Product not found");
        }
    }

    //Display Methods

    public void displayCustomerPayments(String userName) throws CustomerNotFound {
        Customer customer = findCustomer(userName);
        if (customer != null) {
            customer.displaySavedPayments();
        } else {
            throw new CustomerNotFound("ERROR : Customer Not Found");
        }
    }

    public void displayCustomerOrders(String userName) throws CustomerNotFound {
        Customer customer = findCustomer(userName);
        if (customer != null) {
            customer.getMyOrders();
        } else {
            System.out.println("ERROR : Customer not found");
        }
    }

    public void displayCustomerDetails(String userName) throws CustomerNotFound {
        Customer customer = findCustomer(userName);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("ERROR : Customer not found");
        }
    }

    public void displayCart(String userName) throws CustomerNotFound {
        Customer customer = findCustomer(userName);
        if (customer != null) {
            customer.displayCart();
        } else {
            System.out.println("ERROR : Customer not found");
        }
    }

    public void displayAllCustomers() {
        System.out.println("Below are all the customers we have :");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void displayAllProducts() {
        System.out.println("Below are all the products we have :");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void checkout(String userName, String paymentMethod) throws CustomerNotFound, NoSavedPayments {
        Customer customer = findCustomer(userName);
        Payment payment = getPaymentMethod(userName, paymentMethod);
        if (customer == null) {
            throw new CustomerNotFound("ERROR : Customer Not Found");

        } else if (payment == null) {
            throw new NoSavedPayments("ERROR : No saved payment methods found");
        } else {
            order = new Order(customer, customer.getCart());
            order.placeOrder(payment);
        }
    }

    public void addCardPayment(String userName, String cardNumber, String expiryDate, int cvv) throws InvalidCardNumber, CustomerNotFound {
        Customer customer = findCustomer(userName);
        if (customer != null) {
            customer.addCardPayment(cardNumber, expiryDate, cvv);
        } else {
            System.out.println("ERROR : Customer not found");
        }
    }


    public void addUPIPayment(String userName, String upiId) throws InvalidUPIID, CustomerNotFound {
        Customer customer = findCustomer(userName);
        if (customer != null) {
            customer.addUPIPayment(upiId);
        } else {
            System.out.println("ERROR : Customer not found");
        }
    }
}