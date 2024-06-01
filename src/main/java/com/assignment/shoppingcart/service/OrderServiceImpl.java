package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.dto.OrderDto;
import com.assignment.shoppingcart.entity.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDto convertEntityToDto(Order order) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(order, OrderDto.class);
    }

    @Override
    public Order convertDtoToEntity(OrderDto orderDto) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(orderDto, Order.class);
    }

}
