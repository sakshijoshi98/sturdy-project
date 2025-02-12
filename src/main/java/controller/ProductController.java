package controller;

import org.springframework.web.bind.annotation.*;

@RestController

public class ProductController {

    @GetMapping("/product/{id}")
    public void getProductById(@PathVariable("id") Integer id){

    }

    @PostMapping("/product")
    public void createProduct(){

    }

    @GetMapping("/products")
    public void getAllProducts(){

    }

    @PutMapping("/product/{id}")
    public void updateProduct(@PathVariable("id") Integer id){

    }

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") Integer id){

    }
}

