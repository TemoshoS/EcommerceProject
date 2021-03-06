package com.temosho.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temosho.application.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
