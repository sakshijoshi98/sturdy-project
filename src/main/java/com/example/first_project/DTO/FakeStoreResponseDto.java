package com.example.first_project.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponseDto {
    private Integer id;
    private String title;
    private String category;
    private String description;
    private String image;
}
