package com.jacalix.restService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jacalix.model.entity.Customer;
import com.jacalix.model.entity.Product;
import com.jacalix.model.entity.Subscription;
import com.jacalix.model.entity.SubscriptionType;
import com.jacalix.model.entity.View;
import com.jacalix.restController.ProductController;

@Service
public class CustomerService {

	public Subscription addSubscription(Subscription s, int id, List<Customer>customers) {
		
		
		customers.stream().filter(c -> c.getId() == id).forEach((c1)->{
			c1.setSub(s);
		});
		
		return s;
	}
	
	public View addView(View v, int id, List<Customer> customers,int idP) {
		
		Product aux = new Product();
		
		for(Product p : ProductController.getProduct()) {
			if(p.getId() == idP) {
				aux = p;
			}
		}
		
		v.setProductViewed(aux);
		
		customers.stream().filter(c -> c.getId() == id).forEach((c1)->{
			if(c1.getSub().getRentType() == SubscriptionType.GOLD) {
				c1.getViews().add(v);
			}else if(c1.getSub().getRentType() ==SubscriptionType.ADVANCED &&(v.getProductViewed().getRent()==SubscriptionType.ADVANCED || v.getProductViewed().getRent()==SubscriptionType.BASIC)) {
				c1.getViews().add(v);
			}else if(v.getProductViewed().getRent() == SubscriptionType.BASIC) {
				c1.getViews().add(v);
			}
			
			
		});
		
		
		return v;
	}
}
