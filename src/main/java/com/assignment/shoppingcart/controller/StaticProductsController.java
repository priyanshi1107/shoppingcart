package com.assignment.shoppingcart.controller;

import com.assignment.shoppingcart.dto.StaticProductsDto;
import com.assignment.shoppingcart.entity.StaticProducts;
import com.assignment.shoppingcart.service.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StaticProductsController {

    @Autowired
    private HomeServiceImpl homeService;

    @PostMapping("/saveProducts")
    @ResponseBody
    public ResponseEntity<List<StaticProducts>> saveItems(@RequestBody List<StaticProductsDto> staticProductsDtoList) {
        List<StaticProducts> staticProductsList = new ArrayList<>();
        for (StaticProductsDto staticProductsDto : staticProductsDtoList) {

            StaticProducts staticProducts = homeService.convertDtoToEntity(staticProductsDto);
            staticProductsList.add(staticProducts);
        }
        return new ResponseEntity<List<StaticProducts>>(homeService.saveListOfStaticProducts(staticProductsList), HttpStatus.CREATED);
    }
}
