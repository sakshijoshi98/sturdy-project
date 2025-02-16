package com.example.first_project.controller;

import com.example.first_project.DTO.CreateProductRequestDto;
import com.example.first_project.exception.ProductNotFoundException;
import com.example.first_project.model.Product;
import com.example.first_project.service.FakeStoreProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {

    private FakeStoreProductService service;
    public ProductController(FakeStoreProductService inputService) {
         this.service = inputService;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Integer id) throws ProductNotFoundException{

        if(id == 10000){
            throw new IllegalArgumentException("Id should be less than 10000");
        }


        Product product = service.getProductById(id);

        if(product == null){
            throw new ProductNotFoundException("Product not found");
        }

        return product;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto request){
        if(request.getDescription() == null ){
            throw new IllegalArgumentException("description cannot be is null");
        }

        if (request.getTitle() == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }

        return service.createProduct(request.getTitle(),request.getCategory().getTitle(),
                request.getDescription(),request.getImageURL());

    }


    @GetMapping("/products")
    public List<Product> getAllProducts(){
        //1. Do any validation
        //2. call the service layer
        List<Product> products = service.getAllProducts();
        return products;
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable("id") Integer id){

    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable("id") Integer id){

    }
}

