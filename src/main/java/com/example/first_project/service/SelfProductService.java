package com.example.first_project.service;

import com.example.first_project.model.Category;
import com.example.first_project.model.Product;
import com.example.first_project.repository.CategoryRepo;
import com.example.first_project.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductById(Integer id) {
        //this will do database call
        Product response = productRepo.findById(id).get();
        System.out.println("fetched product : " + response);
        return response;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product createProduct(String title, String catTitle, String description, String imageURL) {
        validateInputRequest(title, catTitle, description, imageURL);

        Product product = new Product();
        Category category = new Category();

        product.setTitle(title);
        product.setImageURL(imageURL);
        product.setDescription(description);
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());

        // checking if category exist in db
        Category existingcategory = categoryRepo.findByTitle(catTitle).get();

        if(existingcategory == null) {
            category.setTitle(catTitle);
        }

        // also check exist category
        product.setCategory(category);

        // saving to the db
        Product response = productRepo.save(product);
        return response;
    }

    private void validateInputRequest(String title, String catTitle, String description, String imageURL) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("title cannot be null or empty");
        }
        if (catTitle == null || catTitle.isEmpty()) {
            throw new IllegalArgumentException("catTitle cannot be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("description cannot be null or empty");
        }
        if (imageURL == null || imageURL.isEmpty()) {
            throw new IllegalArgumentException("imageURL cannot be null or empty");
        }

    }
}
