package com.jacaranda.services_impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.jacaranda.services.GameCodeService;

@Service
public class GameCodeServiceImpl implements GameCodeService {

	@Override
	public String getRandomGameCode() {

		String gameCode = "";
		int rnd = 0;

		for (int i = 0; i < 4; i++) {
			rnd = (int) Math.floor(Math.random() *(90-65+1) + 65);
			gameCode += Character.toUpperCase(((char) (rnd)));
		}
		return gameCode;
	}

}
