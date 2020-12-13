package com.jacaranda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_player")
public class Player implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;

	/** ID del jugador */
	private Long playerId;

	/** Nombre de usuario del jugador */
	private String username;

	/** Contraseña del jugador */
	private String password;

	/** Puntuacion total */
	private int score;

	/** Numero de fallos total del jugador */
	private int fails;

	/**
	 * @return the playerId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId the playerId to set
	 */
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	/**
	 * @return the username
	 */
	@Column(name = "player_username", unique=true)
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	@Column(name = "player_password")
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the score
	 */
	@Column(name = "player_score")
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the fails
	 */
	@Column(name = "player_fails")
	public int getFails() {
		return fails;
	}

	/**
	 * @param fails the fails to set
	 */
	public void setFails(int fails) {
		this.fails = fails;
	}

}
