package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.dto.UserDto;
import com.assignment.shoppingcart.entity.User;

public interface UserService {
    UserDto convertEntityToDto(User user);

    User convertDtoToEntity(UserDto userDto);

    User saveUser(User user);
}
