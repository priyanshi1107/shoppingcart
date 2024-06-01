package com.assignment.shoppingcart.service;


import com.assignment.shoppingcart.dao.HomeRepository;
import com.assignment.shoppingcart.entity.StaticProducts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class HomeServiceTest {
    @Autowired
    private HomeService homeService;

    @MockBean
    private HomeRepository homeRepository;

    @Test
    @DisplayName("Test save method of home service success")
    @Order(1)
    void saveListOfStaticProductsTest()
    {
        List<StaticProducts> listOfStaticProducts =  Stream.of(new StaticProducts(1L,"Iphone",1200,"https://d28i4xct2kl5lp.cloudfront.net/product_images/79593_d0e913e5-f2ee-4bae-b6ff-49ac7e2fc283.jpg",2)).collect(Collectors.toList());
        when(homeRepository.saveAll(listOfStaticProducts)).thenReturn(listOfStaticProducts);
        assertEquals(listOfStaticProducts, homeService.saveListOfStaticProducts(listOfStaticProducts));
    }

    @Test
    @DisplayName("getAllStaticProducts method of home service success")
    @Order(2)
    void getAllStaticProductsTest(){
        List<StaticProducts> listOfStaticProducts =  Stream.of(new StaticProducts(1L,"Iphone",1200,"https://d28i4xct2kl5lp.cloudfront.net/product_images/79593_d0e913e5-f2ee-4bae-b6ff-49ac7e2fc283.jpg",2)).collect(Collectors.toList());
        when(homeRepository.findAll()).thenReturn(listOfStaticProducts);
        assertEquals(1, homeService.getAllStaticProducts().size());
    }


}
