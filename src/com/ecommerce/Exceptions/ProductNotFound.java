package com.ecommerce.Exceptions;

public class ProductNotFound extends Exception {
  public ProductNotFound(String message) {
    super(message);
  }
}