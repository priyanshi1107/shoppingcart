package com.assignment.shoppingcart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String productName;
    private double price;
    private String imageUrl;
    private int qty;
    private double total;
//    private Order order;
}
