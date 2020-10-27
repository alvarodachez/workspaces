package com.jacalix.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacalix.model.entity.Product;
@Repository(value = "pr")
public interface ProductRepository extends CrudRepository<Product,Integer>{

	
}
