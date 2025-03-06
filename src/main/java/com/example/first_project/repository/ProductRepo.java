package com.example.first_project.repository;

import com.example.first_project.model.Category;
import com.example.first_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Override
    Optional<Product> findById(Integer id);

    Optional<Product> findByCategory(Category c);

    Optional<Product> findByIdAndCategory(Integer id, Category c);

    Optional<List<Product>> findAllByCategory(Category c);

    void deleteById(Integer id);

    void deleteByCategory(Category c);
}
