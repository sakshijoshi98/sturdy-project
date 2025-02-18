package com.example.first_project.service;

import com.example.first_project.exception.ProductNotFoundException;
import com.example.first_project.model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Integer id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(String title, String catTitle, String description, String imageURL);
}
