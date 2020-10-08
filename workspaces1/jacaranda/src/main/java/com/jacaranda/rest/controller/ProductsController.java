package com.jacaranda.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Product;

/**
 * 
 * @author alvaro
 *
 */

@RestController
@RequestMapping(path="/api")
public class ProductsController {

	private List<Product> products = new ArrayList<>();
	/**
	 * 
	 * @param sent
	 * @return
	 */
	@PostMapping(path = "/products")
	public ResponseEntity<?> createProduct(@RequestBody Product sent) {
		products.add(sent);
		return ResponseEntity.status(HttpStatus.CREATED).body(sent);
	}
	/**
	 * 
	 * @return
	 */
	@GetMapping(path= "/products")
	public ResponseEntity<?> getProducts(){
		if(products!=null && !products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(products);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path="/products/")
	public ResponseEntity<?>getProduct(@RequestParam String id){
		if(products!=null && !products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(products.stream().filter(c -> id.compareTo(c.getId())==0));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
	}
	/**
	 * 
	 * @param sent
	 * @return
	 */
	@PutMapping(path="/products")
	public ResponseEntity<?> updateProduct(@RequestBody Product sent) {
		boolean flag = true;
		for(Product p : products) {
			if(p.getId().compareTo(sent.getId())==0) {
				if(sent.getName().compareTo("")!=0 && sent.getName() !=null) {
					p.setName(sent.getName());
				}
				if(sent.getDescription().compareTo(p.getDescription())!=0 && sent.getDescription() !=null) {
					p.setDescription(sent.getDescription());
				}
				if(sent.getCategory().compareTo(p.getCategory())!=0 && sent.getCategory() !=null) {
					p.setCategory(sent.getCategory());
				}
			}else {
				flag = false;
			}
		}
		
		if(flag==false) {
			return ResponseEntity.status(HttpStatus.OK).body(sent);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path="/products")
	public ResponseEntity<?>deleteProduct(@RequestParam String id){
		boolean flag = true;
		Product aux = new Product();
		for(Product p : products) {
			if(id.compareTo(p.getId())==0) {
				aux = p;
				products.remove(products.indexOf(p));
			}else {
				flag = false;
			}
		}
		
		if(flag == false) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(aux);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
	}
	
	
}
