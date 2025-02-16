package com.example.first_project.DTO;

public class CreateProductRequestDto {
    private String title;
    private String description;
    private String imageURL;
    private CategoryRequestDto category;

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public CategoryRequestDto getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setCategory(CategoryRequestDto category) {
        this.category = category;
    }
}

