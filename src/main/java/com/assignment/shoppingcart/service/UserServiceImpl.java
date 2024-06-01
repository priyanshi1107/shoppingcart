package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.dao.UserRepository;
import com.assignment.shoppingcart.dto.UserDto;
import com.assignment.shoppingcart.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto convertEntityToDto(User user) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(user, UserDto.class);

    }

    @Override
    public User convertDtoToEntity(UserDto userDto) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(userDto, User.class);
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

}
