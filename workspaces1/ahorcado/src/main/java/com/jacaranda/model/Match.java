package com.jacaranda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_match")
public class Match implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;

	/** ID de partida **/
	private Long matchId;

	/** Palabra que adivinar **/
	private String word;

	/** Jugadores en la partida **/
	private List<Player> players = new ArrayList<>();

	/** Errores en la partida **/
	private int fails;

	/** Intentos totales antes de finalizar partida **/
	private int tries;

	/** Codigo de entrada en partida **/
	private String gameCode;

	private String wordAnswer;

	/**
	 * @return the matchId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getMatchId() {
		return matchId;
	}

	/**
	 * @param matchId the matchId to set
	 */
	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}

	/**
	 * @return the word
	 */
	@Column(name = "match_word")
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the players
	 */
	@OneToMany(targetEntity = Player.class)
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * @return the fails
	 */
	@Column(name = "match_fails")
	public int getFails() {
		return fails;
	}

	/**
	 * @param fails the fails to set
	 */
	public void setFails(int fails) {
		this.fails = fails;
	}

	/**
	 * @return the tries
	 */
	@Column(name = "match_tries")
	public int getTries() {
		return tries;
	}

	/**
	 * @param tries the tries to set
	 */
	public void setTries(int tries) {
		this.tries = tries;
	}

	/**
	 * @return the gameCode
	 */
	@Column(name = "match_game_code")
	public String getGameCode() {
		return gameCode;
	}

	/**
	 * @param gameCode the gameCode to set
	 */
	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	@Column(name = "match_word_answer")
	public String getWordAnswer() {
		return wordAnswer;
	}

	public void setWordAnswer(String wordAnswer) {
		this.wordAnswer = wordAnswer;
	}

	public void addPlayer(Player p) {
		this.players.add(p);
	}

}
