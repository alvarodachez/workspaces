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
		m.setWordAnswer(buildAnswer(m.getWord()));

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
				if (m.getFails() == MAX_FAILS) {
					res = "DEFEAT";
				} else {
					res = m.getWordAnswer() + " FAILS: " + m.getFails();
				}
			}

		} else if (answer.length() == 1) {
			// logica para un caracter ( paso a minuscular ir pintando guiones o caracteres
			// (crear atributo en match) cuidar tildes

			checkAnswer(m.getMatchId(), p.getPlayerId(), answer);
			if (m.getFails() == MAX_FAILS) {
				res = "DEFEAT";
			} else {
				res = m.getWordAnswer() + " FAILS: " + m.getFails();
			}
		}

		return res;
	}

	private void checkAnswer(Long matchId, Long playerId, String answer) {

		Match m = matchRepo.findById(matchId).get();
		Player p = playerRepo.findById(playerId).get();

		StringBuilder aux = new StringBuilder(m.getWordAnswer());
		StringBuilder aux1 = new StringBuilder("");

		Boolean flag = false;

		for (int i = 0; i < m.getWord().length(); i++) {
			if (answer.compareTo(String.valueOf(m.getWord().charAt(i))) == 0) {

				flag = true;
				aux.replace(i, i+1, answer);
				//aux1.append(answer);

			} 
//			else if("-".compareTo(String.valueOf(m.getWordAnswer().charAt(i))) != 0){
//				aux1.append(m.getWord().charAt(i));
//			}
		}
		if (flag == false) {

			p.setFails(p.getFails() + 1);
			m.setFails(m.getFails() + 1);
			m.setTries(m.getTries() + 1);
			m.setWordAnswer(aux.toString());
			matchRepo.save(m);
			playerRepo.save(p);
		} else {
			m.setTries(m.getTries() + 1);
			m.setWordAnswer(aux.toString());
			matchRepo.save(m);
		}
	}

	private String buildAnswer(String word) {
		StringBuilder aux = new StringBuilder("");

		int length = word.length();

		for (int i = 0; i < length; i++) {
			aux.append("-");
		}

		return aux.toString();
	}

}
