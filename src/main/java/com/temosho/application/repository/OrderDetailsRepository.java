package com.temosho.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temosho.application.model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{

}
