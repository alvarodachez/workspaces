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

import com.jacalix.model.entity.Product;
import com.jacalix.restService.CollectionService;

@RestController
@RequestMapping(path = "/jacalix/products")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private CollectionService cService;

	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody Product p) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cService.createProduct(p));

	}

	@GetMapping
	public ResponseEntity<?> getProducts() {

		return cService.getProducts();

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product p, @PathVariable("id") Integer id) {

		return ResponseEntity.status(HttpStatus.OK).body(cService.updateProduct(p, id));

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
		return cService.deleteProduct(id);

	}

}
