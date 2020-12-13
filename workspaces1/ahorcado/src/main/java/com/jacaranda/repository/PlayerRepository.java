package com.jacaranda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player,Long>{
	
	public Player findByUsername(String username);

}
