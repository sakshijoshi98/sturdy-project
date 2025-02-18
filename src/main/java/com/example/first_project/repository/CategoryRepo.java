package com.example.first_project.repository;

import com.example.first_project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    // jpa query
    Optional<Category> findByTitle(String catTitle);


    Optional<Category> findById(Integer id);
}
