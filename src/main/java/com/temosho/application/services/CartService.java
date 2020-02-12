package com.temosho.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.temosho.application.model.Cart;
import com.temosho.application.model.CartItems;

@Service
public class CartService {
	
	 private final Cart cart = new Cart();

	    public void addToCart(CartItems cartItem){
	    
	        cart.addToCart(cartItem);
	    }

	     public List<CartItems> getCartItems(){
	    
	        return cart.getCartItems();
	    }

	    public void removeCartItem(CartItems cartItem){
	    
	        cart.removeCartItem(cartItem);
	    }

}
