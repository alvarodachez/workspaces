package com.jacaranda.entity;

import java.util.Comparator;

public class ComparatorNombreCustomer implements Comparator<Customer>{

	@Override
	public int compare(Customer arg0, Customer arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}

}
