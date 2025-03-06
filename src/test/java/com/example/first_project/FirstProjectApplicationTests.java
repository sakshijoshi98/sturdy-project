package com.example.first_project;

import com.example.first_project.model.Product;
import com.example.first_project.repository.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class FirstProjectApplicationTests {

//    @Autowired
//    private ProductRepo productrepo;

    @Test
    void contextLoads() {
    }

//    @Test
//    void testProductRepo() {
//        Optional<Product> product = productrepo.findById(1);
//        System.out.println(product.get());
//    }

}
