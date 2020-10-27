package com.jacalix.restService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jacalix.model.entity.Customer;
import com.jacalix.model.entity.Product;
import com.jacalix.model.entity.Subscription;
import com.jacalix.model.entity.View;
import com.jacalix.repo.ProductRepository;

@Service
public class CollectionService {
	//@Autowired
	//private CrudRepository<Customer, Integer> customerRepository;
	
//	@Autowired
//	private CrudRepository<Product, Integer> productRepository;
	@Autowired
	private ProductRepository pr;

	public Customer createCustomer(Customer c, List<Customer> customers){
		if(c.getSub() == null) {
			c.setSub(new Subscription());
		}
		if(c.getViews()== null) {
			c.setViews(new ArrayList<View>());
		}
		customers.add(c);
		
		return c;
	}
	
	public List<Customer> getCustomers(List<Customer> customers){
		return customers;
	}
	
	public Customer updateCustomer(Customer c1, List<Customer> customers) {
		customers.stream().filter(c -> c.getId() == c1.getId()).forEach((c2)->{
			if(c1.getName()!=null) {
				c2.setName(c1.getName());
			}
			if(c1.getSurname()!=null) {
				c2.setSurname(c1.getSurname());
			}
			if(c1.getDni() !=null) {
				c2.setDni(c1.getDni());
			}
			if((Integer)c1.getAge()!=null) {
				c2.setAge(c1.getAge());
			}
		});
		
		return c1;
	}
	
	public List<Customer> deleteCustomer(Customer c2,List<Customer> customers) {
		customers.stream().filter(c -> c.getId() == c2.getId()).forEach((c1)->{
			customers.remove(customers.indexOf(c1));
		});
		
		return customers;
	}
	
	public Product createProduct(Product p){
		//products.add(p);
	
		Product p1 = p; 
		pr.save(p1);
		
		return p;
	}
	
	public ResponseEntity<?> getProducts(){
		return ResponseEntity.status(HttpStatus.OK).body(pr.findAll());
	}
	
	public Product updateProduct(Product p, Integer id) {
		Product p1 = pr.findById(id).get();
		
		if(p.getName() !=null) {
			p1.setName(p.getName());
		}
		if(p.getDescription() !=null) {
			p1.setDescription(p.getDescription());
		}
		if(p.getRent() !=null) {
			p1.setRent(p.getRent());
		}
		if(p.getCat() !=null) {
			p1.setCat(p.getCat());
		}
//		products.stream().filter(c -> c.getId() == p.getId()).forEach((p2)->{
//			if(p.getName()!=null) {
//				p2.setName(p.getName());
//			}
//			if(p.getDescription()!=null) {
//				p2.setDescription(p.getDescription());
//			}
//			if(p.getCat()!=null) {
//				p2.setCat(p.getCat());
//			}
//			if(p.getRent()!=null) {
//				p2.setRent(p.getRent());
//			}
//		});
		pr.save(p1);
		
		return p1;
	}
	
	public ResponseEntity<?>  deleteProduct(Integer id) {
		pr.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(pr.findAll());
	}
	
	
}
