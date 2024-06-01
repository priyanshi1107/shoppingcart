package com.assignment.shoppingcart.dto;

import com.assignment.shoppingcart.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private double subTotal;
    private double totalTax;
    private double grandTotal;
    private Date orderDate;
    private List<Product> productList;
}
