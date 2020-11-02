package com.jacalix.restService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jacalix.model.entity.Customer;
import com.jacalix.model.entity.Product;
import com.jacalix.model.entity.Subscription;
import com.jacalix.model.entity.SubscriptionType;
import com.jacalix.model.entity.View;
import com.jacalix.repo.CustomerRepository;
import com.jacalix.repo.ProductRepository;
import com.jacalix.repo.SubscriptionRepository;
import com.jacalix.repo.ViewRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository cr;
	@Autowired
	private SubscriptionRepository sr;
	@Autowired
	private ProductRepository pr;
	@Autowired
	private ViewRepository vr;

	public Customer addSubscription(Subscription s, Integer id) {

		Customer c = cr.findById(id).get();
		sr.save(s);
		c.setSub(s);
		cr.save(c);

		return c;
	}

	public Customer addView(View v, int idc, int idp) {

		Customer c = cr.findById(idc).get();
		Product p = pr.findById(idp).get();
		v.setProductViewed(p);
		vr.save(v);
		c.getViews().add(v);
		cr.save(c);

		return c;
	}
	
	public Customer addViewByProductName(Integer id,String productName) {
		Customer c = cr.findById(id).get();
		Product p = pr.findByName(productName);
		
		View v = new View();
		v.setProductViewed(p);
		v.setStartView(LocalDate.now());
		vr.save(v);
		c.getViews().add(v);
		cr.save(c);
		
		return c;

	}

	public ResponseEntity<?> getCustomerByName(String name) {

		return ResponseEntity.status(HttpStatus.OK).body(cr.findByName(name));
	}

	public ResponseEntity<?> getProductsByRent(Integer id) {
		Customer c = cr.findById(id).get();
		List<Product> products = new ArrayList<>();
		if (c.getSub().getRentType() == SubscriptionType.GOLD) {
			products = pr.getProductsByGoldRent();
		} else if (c.getSub().getRentType() == SubscriptionType.ADVANCED) {
			products = pr.getProductsByAdvancedRent();
		} else {
			products = pr.getProductsByBasicRent();
		}

		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
}
