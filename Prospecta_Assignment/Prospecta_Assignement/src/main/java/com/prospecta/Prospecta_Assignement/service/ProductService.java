package com.prospecta.Prospecta_Assignement.service;

import com.prospecta.Prospecta_Assignement.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProductsByCategory(String category);
    public Product addProduct(Product product);
}
