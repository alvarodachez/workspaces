package com.jacalix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacalix.model.entity.Product;
@Repository(value = "pr")
public interface ProductRepository extends CrudRepository<Product,Integer>{

	@Query(value="select * from product where rent = 0 or rent = 1 or rent = 2", nativeQuery = true)
	public List<Product>getProductsByGoldRent();
	@Query(value="select * from product where rent = 0 or rent =1",nativeQuery = true)
	public List<Product>getProductsByAdvancedRent();
	@Query(value="select * from product where rent = 0", nativeQuery = true)
	public List<Product>getProductsByBasicRent();
	
	public Product findByName(String name);
}
