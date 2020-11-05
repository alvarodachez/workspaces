package com.jacalix.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity 
public class View{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@OneToOne(targetEntity = Product.class)
	private Product productViewed;
	private LocalDate startView;
	private LocalDate endView;
	
	public View() {
		super();
	}

	public View(Integer id,Product productViewed, LocalDate startView, LocalDate endView) {
		super();
		this.id = id;
		this.productViewed = productViewed;
		this.startView = startView;
		this.endView = endView;
	}

	public Product getProductViewed() {
		return productViewed;
	}

	public void setProductViewed(Product productViewed) {
		this.productViewed = productViewed;
	}

	public LocalDate getStartView() {
		return startView;
	}

	public void setStartView(LocalDate startView) {
		this.startView = startView;
	}

	public LocalDate getEndView() {
		return endView;
	}

	public void setEndView(LocalDate endView) {
		this.endView = endView;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
