package com.temosho.application.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name ="payments")
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
	private String name;
	private String cardType;
	private String cardName;
	private double ammount;
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="custid")
	private User custpay;
	
	
	
	public Payment() {
		
	}

	public Payment(int paymentId, String name, String cardType, String cardName, double ammount) {
		super();
		this.paymentId = paymentId;
		this.name = name;
		this.cardType = cardType;
		this.cardName = cardName;
		this.ammount = ammount;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public User getCustpay() {
		return custpay;
	}

	public void setCustpay(User custpay) {
		this.custpay = custpay;
	}




	
	
	
}
