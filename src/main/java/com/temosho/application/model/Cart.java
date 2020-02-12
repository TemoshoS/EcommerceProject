package com.temosho.application.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	
	 private List<CartItems> cartItems = new ArrayList<>();
	    
	    public void addToCart(CartItems cartItem) {
	        if (this.getCartItems().isEmpty()) {
	            this.getCartItems().add(cartItem);
	        } else if (!this.getCartItems().isEmpty()) {
	            for (int i = 0; i < this.getSize(); i++) {
	                if (this.getCartItems().get(i).getProduct().getProdname().
	                        equalsIgnoreCase(cartItem.getProduct().getProdname())) {
	                    this.getCartItems().remove(this.getCartItems().get(i));
	                }
	            }
	            this.getCartItems().add(cartItem);
	        }
	    }
	    
	    public void removeCartItem(CartItems cartItems) {
	        for (int i = 0; i < this.getSize(); i++) {
	            if (this.getCartItems().get(i).getProduct().getProdname().equalsIgnoreCase(cartItems.getProduct().getProdname())) {
	                if (this.getCartItems().get(i).getCount() == 1) {
	                    this.getCartItems().remove(this.getCartItems().get(i));
	                } else if (this.getCartItems().get(i).getCount() > 1) {
	                    this.getCartItems().get(i).setCount(this.getCartItems().get(i).getCount() - 1);
	                }
	            }
	        }
	    }
	    
	    public List<CartItems> getCartItems(){
	        return cartItems;
	    }
	    
	    public void setCartItems(List<CartItems> cartItems){
	        this.cartItems = cartItems;
	    }
	    
	    public int getSize(){
	        return this.cartItems.size();
	    }

}
