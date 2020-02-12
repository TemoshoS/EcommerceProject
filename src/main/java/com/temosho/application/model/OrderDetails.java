package com.temosho.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordersdetails")
public class OrderDetails {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    private String ProductName;
	    private int OrderedQuantity;
	    private int PerUnitPrice;
	    
		 //OneToOne relationship
	  
		@OneToOne(mappedBy="orderdetails")
		@JoinColumn(name="orderid")
		private Order order;
		
		
		
		
		
		@ManyToOne
		@JoinColumn(name="productid")
		private Product product;
		
		
		
		
		public OrderDetails() {
			super();
		
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getProductName() {
			return ProductName;
		}

		public void setProductName(String productName) {
			ProductName = productName;
		}

		public int getOrderedQuantity() {
			return OrderedQuantity;
		}

		public void setOrderedQuantity(int orderedQuantity) {
			OrderedQuantity = orderedQuantity;
		}

		public int getPerUnitPrice() {
			return PerUnitPrice;
		}

		public void setPerUnitPrice(int perUnitPrice) {
			PerUnitPrice = perUnitPrice;
		}
		
	

		

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}

		

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}
		
	 
}
