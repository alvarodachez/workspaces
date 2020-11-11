package com.jacalix.restController;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jacalix.model.entity.Product;
import com.jacalix.restService.CollectionService;
import com.jacalix.restService.ProductService;

@RestController
@RequestMapping(path = "/jacalix/products")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private CollectionService cService;
	@Autowired 
	private ProductService productService;

	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody Product p) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cService.createProduct(p));

	}

	@GetMapping
	public ResponseEntity<?> getProducts() {

		return cService.getProducts();

	}
	@GetMapping("/doc/{id}")
	@ResponseBody
	public ResponseEntity<byte[]>getDocument(@PathVariable("id") Integer id) throws SQLException{
		
		
		return productService.getDocument(id);
	}
	
	@GetMapping("/doc/download/{id}")
	public ResponseEntity<Resource> downloadDocument(@PathVariable ("id") Integer id) throws SQLException{
		return productService.downloadDocument(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product p, @PathVariable("id") Integer id) {

		return ResponseEntity.status(HttpStatus.OK).body(cService.updateProduct(p, id));

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
		return cService.deleteProduct(id);

	}
	@PutMapping("/doc/{id}")
	public ResponseEntity<?> addDocument(@RequestParam(name = "pic", required = false) MultipartFile pic, 
			@PathVariable(required = false) Integer id) {
		productService.addDocument(pic, id);
		return ResponseEntity.ok("File "+ pic.getOriginalFilename()+ "successfully uploaded");
	}

}
