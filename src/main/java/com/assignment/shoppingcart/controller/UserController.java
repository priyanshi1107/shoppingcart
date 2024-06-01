package com.assignment.shoppingcart.controller;

import com.assignment.shoppingcart.dto.OrderDto;
import com.assignment.shoppingcart.dto.UserDto;
import com.assignment.shoppingcart.entity.User;
import com.assignment.shoppingcart.service.EmailService;
import com.assignment.shoppingcart.service.OrderServiceImpl;
import com.assignment.shoppingcart.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import java.util.Date;


@Controller
@Slf4j
public class UserController {
    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/transferData")
    public String transferData(@ModelAttribute OrderDto orderDto, HttpSession session) {
        session.setAttribute("orderDto", orderDto);
        return "user";
    }

    @PostMapping("/saveFormData")
    public String saveFormData(@ModelAttribute("userDto") UserDto userDto, HttpSession session) throws MessagingException {

        OrderDto orderDto = (OrderDto) session.getAttribute("orderDto");
        orderDto.setOrderDate(new Date());
        userDto.setOrderDto(orderDto);
        User user = userService.convertDtoToEntity(userDto);
        log.info(String.valueOf(user));
        userService.saveUser(user);
        emailService.sendMail(userDto);
        session.invalidate();
        return "final";
    }

}
