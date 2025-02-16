package com.example.first_project.exception;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException() {

    }
    public ProductNotFoundException(String message) {
        super(message);
    }
}
