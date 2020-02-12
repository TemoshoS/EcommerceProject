package com.temosho.application.controller;

import com.temosho.application.model.CartItems;

import com.temosho.application.services.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/auth")
public class CartController {
    
    @Autowired
    private CartService cartService;
    
    //add products to cart
    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public void addToCart(@RequestBody CartItems cartItem){
    
        cartService.addToCart(cartItem);
    }
    
    
   //display all added items in cart
    @RequestMapping(value = "/listItems", method = RequestMethod.GET)
    public List<CartItems> getCartItems(){
        return cartService.getCartItems();
    }
    
    
    
    //delete item
    @RequestMapping(value = "/deleteItem", method = RequestMethod.PUT)
    public void removeCartItem(@RequestBody CartItems cartItem){
    
        cartService.removeCartItem(cartItem);
    }
    
}
