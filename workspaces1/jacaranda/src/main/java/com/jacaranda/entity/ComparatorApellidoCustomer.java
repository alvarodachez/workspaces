package com.jacaranda.entity;

import java.util.Comparator;

public class ComparatorApellidoCustomer implements Comparator<Customer>{

	@Override
	public int compare(Customer arg0, Customer arg1) {
		// TODO Auto-generated method stub
		return arg0.getSurname().compareTo(arg1.getSurname());
	}

}
