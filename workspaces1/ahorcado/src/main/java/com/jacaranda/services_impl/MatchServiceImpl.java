package com.jacaranda.services_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.model.Match;
import com.jacaranda.model.Player;
import com.jacaranda.repository.MatchRepository;
import com.jacaranda.repository.PlayerRepository;
import com.jacaranda.services.GameCodeService;
import com.jacaranda.services.GetWordService;
import com.jacaranda.services.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	PlayerRepository playerRepo;

	@Autowired
	MatchRepository matchRepo;

	@Autowired
	GetWordService getWordService;

	@Autowired
	GameCodeService codeService;

	private static final int MAX_FAILS = 7;

	@Override
	public Match createMatch(Match m) {

		m.setWord(getWordService.getRandomWord());
		m.setGameCode(codeService.getRandomGameCode());

		matchRepo.save(m);

		return m;
	}

	@Override
	public Match joinMatch(String username, String gameCode) {
		Match m = matchRepo.findByGameCode(gameCode);
		Player p = playerRepo.findByUsername(username);

		m.addPlayer(p);

		return m;
	}

	@Override
	public String sendAnswer(String username, String gameCode, String answer) {
		String res = "";

		Player p = playerRepo.findByUsername(username);

		Match m = matchRepo.findByGameCode(gameCode);

		if (answer.compareTo("") == 0 || answer == null) {
			res = "The answer is incorrect";
		} else if (answer.length() > 1) {
			if (m.getWord().toLowerCase().compareTo(answer.toLowerCase()) == 0) {
				m.setTries(m.getTries() + 1);
				p.setScore(p.getScore() + 1);
				res = "VICTORY";
			} else {
				m.setTries(m.getTries() + 1);
				m.setFails(m.getFails() + 1);
				p.setFails(p.getFails() + 1);
				if (m.getFails() == 7) {
					res = "DEFEAT";
				} else {
					res = "FAIL";
				}
			}

		} else if (answer.length() == 1) {
			//logica para un caracter ( paso a minuscular ir pintando guiones o caracteres (crear atributo en match) cuidar tildes

		}

		return null;
	}

}
