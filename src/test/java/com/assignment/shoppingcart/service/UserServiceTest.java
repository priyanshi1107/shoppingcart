package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.dao.UserRepository;
import com.assignment.shoppingcart.entity.Order;
import com.assignment.shoppingcart.entity.Product;
import com.assignment.shoppingcart.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("saveListOfStaticProductsTest() method of user service success")
    void saveListOfStaticProductsTest()
    {
        List<Product> productList = Arrays.asList(new Product(1L, "iPhone 12", 1000, 1, 1000, "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-white-select-2020?wid=940&hei=1112&fmt=png-alpha&.v=1604343705000"));
        Order order = new Order(1L, 1000.0, 100.0, 1100.0, new Date(), productList);
        User user = new User(1L, "Aayush", "Soni", "aayush13013@gmail.com", "7987970358", "Barwaha", "Barwaha", "Barwaha", "MP", "India", 451115, "Barwaha", "Barwaha", "Barwaha", "MP", "India", 451115, order);
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userService.saveUser(user));
    }
}
