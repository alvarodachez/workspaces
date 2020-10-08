package com.jacaranda.entity;

import java.util.Comparator;

public class ComparatorDniCustomer implements Comparator<Customer>{

	@Override
	public int compare(Customer arg0, Customer arg1) {
		// TODO Auto-generated method stub
		return arg0.getDni().compareTo(arg1.getDni());
	}

}
