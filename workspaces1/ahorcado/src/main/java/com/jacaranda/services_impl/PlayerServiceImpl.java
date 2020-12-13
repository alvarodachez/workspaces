package com.jacaranda.services_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.model.Player;
import com.jacaranda.repository.PlayerRepository;
import com.jacaranda.services.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepo;

	@Override
	public Player createPlayer(Player p) {
		p.setFails(0);
		p.setScore(0);

		playerRepo.save(p);
		return p;
	}
}
