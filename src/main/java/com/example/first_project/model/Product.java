package com.example.first_project.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Integer id;
    private String title;
    private String description;
    private String imageURL;
    private Category category;
}
