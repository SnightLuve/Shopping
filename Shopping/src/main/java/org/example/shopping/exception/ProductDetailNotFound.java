package org.example.shopping.exception;

public class ProductDetailNotFound extends RuntimeException{
    public ProductDetailNotFound(String message) {
        super(message);
    }
}
