package com.temosho.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temosho.application.model.Address;
import com.temosho.application.model.Product;
import com.temosho.application.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	 public List<Address> getAddress() 
	    {
	       return addressRepository.findAll();
	    }
	    
	
	public void addAddress(Address address) {
        addressRepository.save(address);
    }

}
