package com.temosho.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "Orders")
public class Order {
	

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	 
	   
	  
	    private String Username;
	    private String Deliveryaddress;
	    private String Phone;
	    private String Orderpaymethod;
	    private String Paymentrefrenceid;
	    
	  
	    @ManyToOne
	    @JoinColumn(name="customerid")
	    private User custorder;

		
	
		
		@ManyToOne
		@JoinColumn(name="orderid")
		private OrderDetails orderdetails;
		
	    
		public Order() {
			
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}




		public String getUsername() {
			return Username;
		}


		public void setUsername(String username) {
			Username = username;
		}


		public String getDeliveryaddress() {
			return Deliveryaddress;
		}


		public void setDeliveryaddress(String deliveryaddress) {
			Deliveryaddress = deliveryaddress;
		}


		public String getPhone() {
			return Phone;
		}


		public void setPhone(String phone) {
			Phone = phone;
		}


		public String getOrderpaymethod() {
			return Orderpaymethod;
		}


		public void setOrderpaymethod(String orderpaymethod) {
			Orderpaymethod = orderpaymethod;
		}


		public String getPaymentrefrenceid() {
			return Paymentrefrenceid;
		}


		public void setPaymentrefrenceid(String paymentrefrenceid) {
			Paymentrefrenceid = paymentrefrenceid;
		}


		public OrderDetails getOrderdetails() {
			return orderdetails;
		}


		public void setOrderdetails(OrderDetails orderdetails) {
			this.orderdetails = orderdetails;
		}


		public User getCustorder() {
			return custorder;
		}


		public void setCustorder(User custorder) {
			this.custorder = custorder;
		}

		
	
	    
	    
	
}
