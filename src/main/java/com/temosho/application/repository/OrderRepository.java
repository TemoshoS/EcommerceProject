package com.temosho.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temosho.application.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
