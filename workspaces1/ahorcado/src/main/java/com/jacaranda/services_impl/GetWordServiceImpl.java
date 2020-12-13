package com.jacaranda.services_impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jacaranda.services.GetWordService;

@Service
public class GetWordServiceImpl implements GetWordService {

	/** Ruta del fichero con todas las palabras **/
	private final static String WORDS_PATH = "src/main/resources/doc/words.txt";

	/** Logger para trazas **/
	private Logger logger = LoggerFactory.getLogger(getClass());;

	@Override
	public String getRandomWord() {

		
		FileReader fr = null;
		BufferedReader br = null;
		
		String word = "";
		
		int randomNumber = getRandomNumber();
		int acum = 0;

		try {
			fr = new FileReader(WORDS_PATH);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null && acum!=randomNumber) {

				
				if(acum == randomNumber -1) {
					word = line;
					
				}
				acum++;
			}
			
		} catch (Exception e) {

			System.out.println(e);
			logger.info("Error reading file");
		} finally {
			try {

				if(null!=fr) {
					fr.close();
				}
			} catch (Exception e2) {

				logger.info("Error closing file");
			}
		}
		
		return word;
		
	}
	
	private int getRandomNumber() {
		return (int)Math.floor(Math.random()*107715 +1);
	}

}
