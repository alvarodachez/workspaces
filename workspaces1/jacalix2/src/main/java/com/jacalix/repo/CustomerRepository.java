package com.jacalix.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacalix.model.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer>{

	public Customer findByName(String name);
	
}
