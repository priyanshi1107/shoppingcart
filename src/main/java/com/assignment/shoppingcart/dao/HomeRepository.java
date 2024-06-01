package com.assignment.shoppingcart.dao;

import com.assignment.shoppingcart.entity.StaticProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<StaticProducts,Long> {
}
