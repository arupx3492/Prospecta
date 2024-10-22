package com.prospecta.RemoteAPICall.service;

import com.prospecta.RemoteAPICall.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProductsByCategory(String category);
    public Product addProduct(Product product);
}
