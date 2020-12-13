package com.jacaranda.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.model.Match;
import com.jacaranda.services.MatchService;

@RestController
@RequestMapping(path = "/ahorcado/match")
@CrossOrigin(origins = "*")
public class MatchController {

	@Autowired
	MatchService matchService;

	@PostMapping
	public ResponseEntity<?> createMatch(@RequestBody Match m) {

		return ResponseEntity.status(HttpStatus.CREATED).body(matchService.createMatch(m));
	}

	@PostMapping(path = "/{username}&&{gameCode}")
	public ResponseEntity<?> joinMatch(@PathVariable("username") String username,
			@PathVariable("gameCode") String gameCode) {
		return ResponseEntity.status(HttpStatus.OK).body(matchService.joinMatch(username, gameCode));
	}

	@PostMapping(path = "/{username}&&{gameCode}&&{answer}")
	public ResponseEntity<?> sendAnswer(@PathVariable("username") String username,
			@PathVariable("gamecode") String gameCode, @PathVariable("answer") String answer) {
		return ResponseEntity.status(HttpStatus.OK).body(matchService.sendAnswer(username, gameCode, answer));
	}

}
