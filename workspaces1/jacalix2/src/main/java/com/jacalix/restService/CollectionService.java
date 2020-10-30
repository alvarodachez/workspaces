package com.jacalix.restService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jacalix.model.entity.Customer;
import com.jacalix.model.entity.Product;
import com.jacalix.repo.CustomerRepository;
import com.jacalix.repo.ProductRepository;

@Service
public class CollectionService {

	@Autowired
	private ProductRepository pr;
	@Autowired
	private CustomerRepository cr;

	public Customer createCustomer(Customer c) {

		Customer c1 = c;

		cr.save(c1);

		return c;
	}

	public ResponseEntity<?> getCustomers() {
		return ResponseEntity.status(HttpStatus.OK).body(cr.findAll());
	}

	public Customer updateCustomer(Customer c, Integer id) {
		Customer c1 = cr.findById(id).get();

		if (c.getName() != null) {
			c1.setName(c.getName());
		}
		if (c.getSurname() != null) {
			c1.setSurname(c.getSurname());
		}
		if ((Integer) c.getAge() != null) {
			c1.setAge(c.getAge());
		}
		if (c.getDni() != null) {
			c1.setDni(c.getDni());
		}

		cr.save(c1);

		return c1;
	}

	public ResponseEntity<?> deleteCustomer(Customer c, Integer id) {
		cr.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(cr.findAll());
	}

	public Product createProduct(Product p) {

		Product p1 = p;
		pr.save(p1);

		return p;
	}

	public ResponseEntity<?> getProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(pr.findAll());
	}

	public Product updateProduct(Product p, Integer id) {
		Product p1 = pr.findById(id).get();

		if (p.getName() != null) {
			p1.setName(p.getName());
		}
		if (p.getDescription() != null) {
			p1.setDescription(p.getDescription());
		}
		if (p.getRent() != null) {
			p1.setRent(p.getRent());
		}
		if (p.getCat() != null) {
			p1.setCat(p.getCat());
		}

		pr.save(p1);

		return p1;
	}

	public ResponseEntity<?> deleteProduct(Integer id) {
		pr.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(pr.findAll());
	}

}
