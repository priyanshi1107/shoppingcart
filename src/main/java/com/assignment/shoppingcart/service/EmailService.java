package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.dto.UserDto;

import javax.mail.MessagingException;

public interface EmailService {

    String sendMail(UserDto userDto) throws MessagingException;
}
