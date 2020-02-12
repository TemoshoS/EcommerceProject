package com.temosho.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.temosho.application.model.Address;

import com.temosho.application.services.AddressService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/auth")

public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	 @CrossOrigin
	    @RequestMapping(value =  "/saveAddress" , method = RequestMethod.POST)
	    public String saveAddress(@RequestBody Address address){
	        addressService.addAddress(address);
	        return "address saved succesfully";
	    }

}
