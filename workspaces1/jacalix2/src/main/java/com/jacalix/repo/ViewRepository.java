package com.jacalix.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacalix.model.entity.View;

@Repository
public interface ViewRepository extends CrudRepository<View,Integer>{

}
