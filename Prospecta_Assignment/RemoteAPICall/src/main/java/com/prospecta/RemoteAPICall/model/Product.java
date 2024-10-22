package com.prospecta.RemoteAPICall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;


}
