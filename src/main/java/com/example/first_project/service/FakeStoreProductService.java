package com.example.first_project.service;

import com.example.first_project.DTO.FakeStoreResponseDto;
import com.example.first_project.model.Category;
import com.example.first_project.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreService")
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Integer id) {

        Product product = new Product();

        // 1. call fakestore api = use restTemplate
        ResponseEntity<FakeStoreResponseDto> fakeStoreResponse =
                restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, FakeStoreResponseDto.class);
        //2. get response
        FakeStoreResponseDto response = fakeStoreResponse.getBody();

        if(response == null) {
            throw new IllegalArgumentException("No fakeStoreproduct found ");
        }
        //3. convert the response to product model
        product = convertFakeStoreResponseToProduct(response);
        return product;
    }

    private Product convertFakeStoreResponseToProduct(FakeStoreResponseDto response) {
        Product product = new Product();
        Category category = new Category();
        category.setTitle(response.getCategory());

        product.setId(response.getId());
        product.setCategory(category);
        product.setDescription(response.getDescription());
        product.setImageURL(response.getImage());
        product.setTitle(response.getTitle());

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> response = new ArrayList<>();

        ResponseEntity<FakeStoreResponseDto[]> fakeStoreProducts =
                restTemplate.getForEntity("https://fakestoreapi.com/products/", FakeStoreResponseDto[].class);
        // next convert the response

        System.out.println("Status Code : " + fakeStoreProducts.getStatusCode());
        for(FakeStoreResponseDto fakeStoreDto : fakeStoreProducts.getBody()){
            response.add(convertFakeStoreResponseToProduct(fakeStoreDto));
        }
        return response;
    }

    @Override
    public Product createProduct(String title, String catTitle, String description, String imageURL) {
        Product response;

        FakeStoreResponseDto requestBody = new FakeStoreResponseDto();
        requestBody.setCategory(catTitle);
        requestBody.setDescription(description);
        requestBody.setImage(imageURL);
        requestBody.setTitle(title);

        ResponseEntity<FakeStoreResponseDto> fakeStoreResponse =
                restTemplate.postForEntity("https://fakestoreapi.com/products",requestBody,FakeStoreResponseDto.class);

        response = convertFakeStoreResponseToProduct(fakeStoreResponse.getBody());

        return response;
    }


}

