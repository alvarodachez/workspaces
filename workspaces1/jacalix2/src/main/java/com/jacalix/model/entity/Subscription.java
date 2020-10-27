package com.jacalix.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private SubscriptionType rentType;
	private LocalDate startSuscription;
	private LocalDate endSuscription;
	private int price;
	
	public Subscription() {
		
	}
	
	public Subscription(int id,SubscriptionType rentType, LocalDate startSuscription,LocalDate endSuscription,int price) {
		this.id = id;
		this.rentType = rentType;
		this.startSuscription = startSuscription;
		this.endSuscription = endSuscription;
		this.price = price;
	}

	public SubscriptionType getRentType() {
		return rentType;
	}

	public void setRentType(SubscriptionType rentType) {
		this.rentType = rentType;
	}

	public LocalDate getStartSuscription() {
		return startSuscription;
	}

	public void setStartSuscription(LocalDate startSuscription) {
		this.startSuscription = startSuscription;
	}

	public LocalDate getEndSuscription() {
		return endSuscription;
	}

	public void setEndSuscription(LocalDate endSuscription) {
		this.endSuscription = endSuscription;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
