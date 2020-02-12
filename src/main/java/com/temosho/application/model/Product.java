package com.temosho.application.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="product")
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Product {
	
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="id")
	    private int id;
	  
	    
	    @Column(name="productname")
	    private String prodname;
	    
	    @Column(name="description")
	    private String proddecription;
	    
	   
	    
	    @Column(name="productprice")
	    private int prodprice;
	    
	    @Column(name="category")
	    private String category;
	    
	    @Column(name="aquantity")
	    private int prodquantity;
	    
	    @Column(name="logo")
	    private byte[] logo;
	    @Column(name="file_name")
	    private String file_name;
	    
	    @OneToMany(cascade=CascadeType.ALL,mappedBy="product")
	    private List<OrderDetails> orderdetails = new ArrayList<>();
	    
	    
	   
	    
	    
         public Product() {
		
		}






		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}



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





		public byte[] getLogo() {
			return logo;
		}





		public void setLogo(byte[] logo) {
			this.logo = logo;
		}





		public String getFile_name() {
			return file_name;
		}





		public void setFile_name(String file_name) {
			this.file_name = file_name;
		}






		public List<OrderDetails> getOrderdetails() {
			return orderdetails;
		}






		public void setOrderdetails(List<OrderDetails> orderdetails) {
			this.orderdetails = orderdetails;
		}



		

		
         
         

		
	    
	    
}
