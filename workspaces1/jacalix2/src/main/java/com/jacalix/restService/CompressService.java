package com.jacalix.restService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.stereotype.Service;

@Service
public class CompressService {
	
	public void createZip() {
		byte [] buffer = new byte[1024];
		
		try {
			FileOutputStream fos = new FileOutputStream("/home/alvaro/Escritorio/JacalixFrontPrimeraVersion/img/archivo.zip");
			ZipOutputStream zos = new ZipOutputStream(fos);
			ZipEntry ze= new ZipEntry("peakyIcon.jpg");
			FileInputStream in = new FileInputStream("/home/alvaro/Escritorio/JacalixFrontPrimeraVersion/img/peakyIcon.jpg");
			
			int len;
	        while ((len = in.read(buffer)) > 0) {
	          zos.write(buffer, 0, len);
	        }
	        
	        in.close();
	        zos.closeEntry();
	           
	        zos.close();
	          
	        System.out.println("Hecho");
			zos.putNextEntry(ze);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
