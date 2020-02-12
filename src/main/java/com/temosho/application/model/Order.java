package com.temosho.application.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "Orders")
public class Order {
	

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	 
	   
	  
	    private String CustomerName;
	    private String DeliveryAddress;
	    private String Phone;
	    private String OrderPayMethod;
	    private String PaymentRefrenceId;
	    
	  
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


		public String getCustomerName() {
			return CustomerName;
		}


		public void setCustomerName(String customerName) {
			CustomerName = customerName;
		}


		public String getDeliveryAddress() {
			return DeliveryAddress;
		}


		public void setDeliveryAddress(String deliveryAddress) {
			DeliveryAddress = deliveryAddress;
		}


		public String getPhone() {
			return Phone;
		}


		public void setPhone(String phone) {
			Phone = phone;
		}


		public String getOrderPayMethod() {
			return OrderPayMethod;
		}


		public void setOrderPayMethod(String orderPayMethod) {
			OrderPayMethod = orderPayMethod;
		}


		public String getPaymentRefrenceId() {
			return PaymentRefrenceId;
		}


		public void setPaymentRefrenceId(String paymentRefrenceId) {
			PaymentRefrenceId = paymentRefrenceId;
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
