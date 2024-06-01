package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.dto.StaticProductsDto;
import com.assignment.shoppingcart.entity.StaticProducts;
import java.util.List;

public interface HomeService {
    StaticProducts convertDtoToEntity(StaticProductsDto staticProductsDto);

    StaticProductsDto convertEntityToDto(StaticProducts staticProducts);

    List<StaticProducts> saveListOfStaticProducts(List<StaticProducts> staticProductsList);

    List<StaticProductsDto> getAllStaticProducts();
}
