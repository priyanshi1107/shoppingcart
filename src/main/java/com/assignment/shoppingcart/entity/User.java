package com.assignment.shoppingcart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private String billingAddress1;
    private String billingAddress2;
    private String city1;
    private String state1;
    private String country1;
    private Integer zipCode1;

    private String shippingAddress1;
    private String shippingAddress2;
    private String city2;
    private String state2;
    private String country2;
    private Integer zipCode2;

    @OneToOne(cascade = CascadeType.ALL)
    private Order order;

}
