package com.jacalix.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String username;
	private String password;
	private String name;
	private String surname;
	private String dni;
	private int age;
	private UserType userType;
	@OneToOne(targetEntity = Subscription.class)
	private Subscription sub;
	@OneToMany(targetEntity = View.class)
	private List<View>views;
	
	public Customer () {
		
	}
	
	public Customer (Integer id, String username,String password, String name, String surname, String dni, int age,Subscription sub, UserType userType) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.age = age;
		this.sub = sub;
		this.userType = userType;
		this.views = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Subscription getSub() {
		return sub;
	}

	public void setSub(Subscription sub) {
		this.sub = sub;
	}

	
	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<View> getViews() {
		return views;
	}

	public void setViews(List<View> views) {
		this.views = views;
	}
	
	
	
//	public void addView(View v) {esto iria en el controller o en servicio
//		this.views.add(v);
//	}
	
	
}
