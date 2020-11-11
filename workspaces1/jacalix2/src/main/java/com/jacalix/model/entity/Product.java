package com.jacalix.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable{
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private SubscriptionType rent;
	private Category cat;
	@OneToOne(targetEntity = Document.class)
	@JsonIgnore
	private Document doc;
	
	
	
	
	public Product () {
		
	}
	
	public Product (Integer id,String name,String description,SubscriptionType rent,Category cat) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rent = rent;
		this.cat = cat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SubscriptionType getRent() {
		return rent;
	}

	public void setRent(SubscriptionType rent) {
		this.rent = rent;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	

	
	
	
	
	
	
	

}
