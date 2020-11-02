package com.jacalix.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacalix.model.entity.Customer;
import com.jacalix.model.entity.Subscription;
import com.jacalix.model.entity.View;
import com.jacalix.restService.CollectionService;
import com.jacalix.restService.CustomerService;

@RestController
@RequestMapping(path = "/jacalix/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	private CollectionService cService;

	@Autowired
	private CustomerService cusService;

	@PostMapping
	public ResponseEntity<?> createCustomer(@RequestBody Customer c) {

		return ResponseEntity.status(HttpStatus.CREATED).body(cService.createCustomer(c));

	}

	@GetMapping
	public ResponseEntity<?> getCustomers() {

		return cService.getCustomers();

	}

	@GetMapping("/{name}")
	public ResponseEntity<?> getCustomerByName(@PathVariable("name") String name) {
		return cusService.getCustomerByName(name);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductsByRent(@PathVariable("id") Integer id) {
		return cusService.getProductsByRent(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer c1, @PathVariable("id") Integer id) {

		return ResponseEntity.status(HttpStatus.OK).body(cService.updateCustomer(c1, id));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteCustomer(@RequestBody Customer c, @PathVariable("id") Integer id) {
		return cService.deleteCustomer(c, id);
	}

	@PutMapping(path = "/subs/{id}")
	public ResponseEntity<?> addSubscription(@RequestBody Subscription s, @PathVariable("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(cusService.addSubscription(s, id));
	}

	@PutMapping(path = "/view/{idc}&&{idp}")
	public ResponseEntity<?> addView(@RequestBody View v, @PathVariable("idc") Integer idc,
			@PathVariable("idp") Integer idp) {

		return ResponseEntity.status(HttpStatus.OK).body(cusService.addView(v, idc, idp));

	}

	@PutMapping(path = "/viewName/{id}&&{productName}")
	public ResponseEntity<?> addViewByProductName(@PathVariable("id") Integer id,
			@PathVariable("productName") String name) {
		return ResponseEntity.status(HttpStatus.OK).body(cusService.addViewByProductName(id, name));
	}

}
