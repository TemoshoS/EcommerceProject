package com.temosho.application.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.temosho.application.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	

}
