package com.temosho.application.services;

import com.temosho.application.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.temosho.application.repository.ProductRepository;

@Service
public class ProductService {
	
	 @Autowired
	    private ProductRepository productRespository;
	 
	 
	            
	    public List<Product> getAllProduct() 
	    {
	       return productRespository.findAll();
	    }
	    
	    
	    public Product save(Product product)
	    {
	     return productRespository.save(product);
	    }
	    
	    
	    public Product getProduct(int id)
	    {
	    
	        return productRespository.getOne(id);
	    }
	    
	    public void addProduct(Product product) 
	    {
	        productRespository.save(product);
	    }

	    public void deleteProduct(int id)
	    {
	        productRespository.deleteById(id);
	    }

	    public Product updateProduct(Product product)
	    {
	        return productRespository.save(product);
	    }

	   

}
