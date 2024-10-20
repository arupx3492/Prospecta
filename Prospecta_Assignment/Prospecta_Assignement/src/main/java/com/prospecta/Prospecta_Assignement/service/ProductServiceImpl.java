package com.prospecta.Prospecta_Assignement.service;

import com.prospecta.Prospecta_Assignement.exceptions.ResourceNotFoundException;
import com.prospecta.Prospecta_Assignement.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    RestTemplate restTemplate;

    private final String BASE_URL = "https://fakestoreapi.com/products";

    @Override
    public List<Product> getProductsByCategory(String category) {
        String url = BASE_URL + "/category/" + category;
        Product[] products = restTemplate.getForObject(url, Product[].class);
        if (products == null || products.length == 0) {
            throw new ResourceNotFoundException("No products found in the category: " + category);
        }
        return Arrays.asList(products);
    }

    @Override
    public Product addProduct(Product product) {
        return restTemplate.postForObject(BASE_URL, product, Product.class);
    }
}
