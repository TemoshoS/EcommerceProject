package com.temosho.application.model;


public class CartItems {
	
	

	
    private Product product;
    private int count;
    
    
    public CartItems(){
        
    }

    public CartItems(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
