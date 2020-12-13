package com.jacalix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jacalix.model.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	public List<Customer>findByName(String name);
	
	public Customer findByUserName(String username); 

	@Query(value = "SELECT * FROM customer WHERE name LIKE ?1%", nativeQuery = true)
	public List<Customer> findByInitials(@Param("initials") String initials);
}
