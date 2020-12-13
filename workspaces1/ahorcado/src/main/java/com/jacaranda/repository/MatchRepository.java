package com.jacaranda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.model.Match;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long>{
	
	public Match findByGameCode(String gameCode);

}
