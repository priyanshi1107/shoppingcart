package com.assignment.shoppingcart.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaticProductsDto {
    private Long id;
    private String productName;
    private int price;
    private String imageUrl;
    private int maxQtyAllowed;
}
