package com.jacaranda.customer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import com.jacaranda.entity.*;
class CustomerHandlerTest {
	
	private List<Customer> customer = new ArrayList<>() {
		{
			add(new Customer("Alvaro","D","Sevilla","12345A",3));
			add(new Customer("Irene","D","Sevilla","12345B",2));
			add(new Customer("Yi","D","Sevilla","12345C",1));
			add(new Customer("Raul","D","Sevilla","12345D",0));
		}
	};
	private List<Customer> customer1 = new ArrayList<>() {
		{
			add(new Customer("Raul","D","Sevilla","12345D",0));
			add(new Customer("Yi","D","Sevilla","12345C",1));
			add(new Customer("Irene","D","Sevilla","12345B",2));
			add(new Customer("Alvaro","D","Sevilla","12345A",3));
			
		}
	};
	@Test
	void testFaulOnNull() {
		List<Customer> customers = null;
		
		try {
			customers.stream().sorted();
		}catch(Exception e) {
			assert(true);
		}
	}
	
	@Test
	void testFaulOnEmpty() {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			customers.remove(2);
		}catch(Exception e) {
			assert(true);
		}
		
	}
	
	@Test
	void testOrderedColecction() {
		
		Collections.sort(this.customer,new ComparatorIdCustomer());
		
		if(((Integer)customer.get(0).getId()).compareTo(((Integer)customer.get(1).getId()))<0) {
			assert(true);
		}else {
			assert(false);
		}
	}

}
