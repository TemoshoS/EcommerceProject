package com.temosho.application.controller;

import com.temosho.application.model.Product;
import com.temosho.application.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.temosho.application.exception.ResourceNotFoundException;
import com.temosho.application.exchange.Response;
import com.temosho.application.services.ProductService;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/auth")
public class ProductController {
	
    @Autowired
    private ProductService  productService;
    
   @Autowired
   private ProductRepository productRepository;
    
   
    

    //add product
    @CrossOrigin
    @PostMapping(value = "saveProduct")
    public ResponseEntity<Response> saveProduct(@RequestParam("file")MultipartFile file, @RequestParam("user") String user) throws JsonParseException,JsonMappingException, IOException{
    	
    	Product product = new ObjectMapper().readValue(user, Product.class);
    	product.setLogo(file.getBytes());
    	product.setFile_name(file.getOriginalFilename());
    	
    	Product dbProduct = productService.save(product);
    	
    	if(dbProduct != null)
    	{
    		return new ResponseEntity<Response>(new Response("Product saved successfully"), HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<Response>(new Response("Product is not saved "), HttpStatus.BAD_REQUEST);
    	}
    	
    }
    
    
    
    //update product
    @CrossOrigin
    @PutMapping("/product/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id,
			@Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

		
		product.setProdname(productDetails.getProdname());
		product.setProddecription(productDetails.getProddecription());
		product.setCategory(productDetails.getCategory());
		product.setProdprice(productDetails.getProdprice());
		product.setProdquantity(productDetails.getProdquantity());
		final Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
    
    
    
    
    //list products
    @CrossOrigin
    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    
    
    
   
    //delete product
    @CrossOrigin
    @DeleteMapping(value = "/product/delete/{id}")
    public boolean deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return true;
    }
    
    
    
    //get product by id only selected fields
    @CrossOrigin
    @GetMapping(value = "/product/get/{id}")
    public List<Object[]> getProductById(@PathVariable int id){
    	
      return productRepository.getProductById(id);
       
    }
    
    
    
    
   
    
    

}
