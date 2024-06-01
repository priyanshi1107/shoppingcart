package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.dto.OrderDto;
import com.assignment.shoppingcart.entity.Order;


public interface OrderService {
    OrderDto convertEntityToDto(Order order);

    Order convertDtoToEntity(OrderDto orderDto);

}
