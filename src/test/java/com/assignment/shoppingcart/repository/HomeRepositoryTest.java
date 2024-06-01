package com.assignment.shoppingcart.repository;

import com.assignment.shoppingcart.dao.HomeRepository;
import com.assignment.shoppingcart.entity.StaticProducts;
import com.assignment.shoppingcart.entity.User;
import org.assertj.core.api.Assertions;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class HomeRepositoryTest {

    @Autowired
    private HomeRepository repository;

    @Test
    @DisplayName("Test of homerepository findAll() method success")
    void getAllStaticProductsTest(){
        List<StaticProducts> staticProductsList = repository.findAll();
        Assertions.assertThat(staticProductsList.size()).isGreaterThan(0);
    }
    @Test
    @DisplayName("Test for saveAll Static products success")
    void saveStaticProductsTest(){
        List<StaticProducts> staticProductsList = Arrays.asList(new StaticProducts(1L,"Iphone",1200,"https://d28i4xct2kl5lp.cloudfront.net/product_images/79593_d0e913e5-f2ee-4bae-b6ff-49ac7e2fc283.jpg",2),new StaticProducts(2L,"OnePlus",1000,"https://cdn.mos.cms.futurecdn.net/dqhGrKneeXCGFBotqgqRia.png",2));
        repository.saveAll(staticProductsList);
        Iterable<StaticProducts> findAll = repository.findAll();
        Assertions.assertThat(findAll).hasSize(2);
    }
}
