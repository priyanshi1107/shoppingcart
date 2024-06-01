package com.assignment.shoppingcart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @Size(max = 256)
    private String firstName;

    @Size(max = 256)
    private String lastName;

    @Email
    private String email;

    @Size(max = 256)
    private String phone;

    @Size(max = 256)
    private String billingAddress1;

    @Size(max = 256)
    private String billingAddress2;

    @Size(max = 256)
    private String city1;

    @Size(max = 256)
    private String state1;

    @Size(max = 256)
    private String country1;

    @Size(max = 256)
    private String zipCode1;


    @Size(max = 256)
    private String shippingAddress1;

    @Size(max = 256)
    private String shippingAddress2;

    @Size(max = 256)
    private String city2;

    @Size(max = 256)
    private String state2;

    @Size(max = 256)
    private String country2;

    @Size(max = 256)
    private String zipCode2;

    private OrderDto orderDto;


}
