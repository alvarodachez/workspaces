package com.jacaranda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jacaranda.entity.*;

/**
 * Controller to manage customer related requests
 * @author Alvaro
 */
	
	@RestController
	@RequestMapping(path="/test")
public class CustomerController {

		private List<Customer> customers = new ArrayList<>();
		
		
		
//		@GetMapping(path="/customers")
//		public List<Customer>getCustomers(){
//			
//			Collections.sort(customers,new ComparatorIdCustomer());
//			
//			return this.customers;
//		}
		
		@GetMapping(path="/customers")
		public List<Customer>getCustomersOrdenadas(@RequestParam String sortv){
			if(sortv.compareTo("id") == 0) {
				Collections.sort(customers, new ComparatorIdCustomer());
			}else if(sortv.compareTo("nombre") == 0){
				Collections.sort(customers,new ComparatorNombreCustomer());
			}else if(sortv.compareTo("apellido") == 0) {
				Collections.sort(customers, new ComparatorApellidoCustomer());
			}else if(sortv.compareTo("dni")==0) {
				Collections.sort(customers, new ComparatorDniCustomer());
			}
			
			return customers;
		}
		
		@GetMapping(path="/customer")
		public ResponseEntity<?> getCustomers(){
			
			
			//List<Customer> res = customers.stream().sorted().collect(Collectors.toList());
			
			if(customers!=null && !customers.isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK).body(customers);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bad Request Performed");
			}
			
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		
		
		
		
}
