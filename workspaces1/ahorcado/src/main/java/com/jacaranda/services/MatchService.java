package com.jacaranda.services;

import com.jacaranda.model.Match;

public interface MatchService {

	public Match createMatch(Match m);

	public Match joinMatch(String username, String gameCode);

	public String sendAnswer(String username, String gameCode, String answer);
}
