package com.jacalix.restService;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileHandlerService{

	public Blob createBlob(MultipartFile file) {
		
		Blob blob = null;
		try {
			blob = new SerialBlob(file.getInputStream().readAllBytes());
		} catch (SQLException | IOException e) {
			
		}
		return blob;
	}


}
