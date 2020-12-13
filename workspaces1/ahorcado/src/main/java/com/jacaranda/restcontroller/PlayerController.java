package com.jacaranda.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.model.Player;
import com.jacaranda.services.PlayerService;

@RestController
@RequestMapping(path = "/ahorcado/player")
@CrossOrigin(origins = "*")
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@PostMapping
	public ResponseEntity<?> createPlayer(@RequestBody Player p) {

		return ResponseEntity.status(HttpStatus.CREATED).body(playerService.createPlayer(p));
	}
}
