package com.temosho.application.repository;

import java.util.List;


import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.temosho.application.model.Product;

@EnableJdbcRepositories
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("SELECT product.prodname, product.proddecription,product.prodprice,product.category,product.prodquantity FROM Product product WHERE product.id = :id")
	List<Object[]> getProductById(@Param("id") int id);


}
