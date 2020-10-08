package com.jacaranda.entity;

import java.util.Comparator;

public class ComparatorIdCustomer implements Comparator<Customer> {

	@Override
	public int compare(Customer arg0, Customer arg1) {
		// TODO Auto-generated method stub
		return ((Integer)arg0.getId()).compareTo(arg1.getId());
	}

}
