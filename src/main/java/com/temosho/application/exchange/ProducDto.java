package com.temosho.application.exchange;

import javax.persistence.Column;

public class ProducDto {

	
	
	 
	    private String prodname;
	    
	    
	    private String proddecription;
	    
	   
	    
	   
	    private int prodprice;
	    
	    
	    private String category;
	    
	   
	    private int prodquantity;


		public String getProdname() {
			return prodname;
		}


		public void setProdname(String prodname) {
			this.prodname = prodname;
		}


		public String getProddecription() {
			return proddecription;
		}


		public void setProddecription(String proddecription) {
			this.proddecription = proddecription;
		}


		public int getProdprice() {
			return prodprice;
		}


		public void setProdprice(int prodprice) {
			this.prodprice = prodprice;
		}


		public String getCategory() {
			return category;
		}


		public void setCategory(String category) {
			this.category = category;
		}


		public int getProdquantity() {
			return prodquantity;
		}


		public void setProdquantity(int prodquantity) {
			this.prodquantity = prodquantity;
		}
	    
	    
	    
}
