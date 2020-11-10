package com.jacalix.restService;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jacalix.model.entity.Document;
import com.jacalix.model.entity.Product;
import com.jacalix.repo.DocumentRepository;
import com.jacalix.repo.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private FileHandlerService fhService;

	public Product addDocument(MultipartFile mpf,Integer id) throws SerialException, SQLException, IOException {
		Document doc = documentRepository.save( new Document(fhService.createBlob(mpf), 
				 mpf.getName(), 
				 Integer.valueOf((int) mpf.getSize()))
);
		Product p =  productRepository.findById(id).get();
		p.getDoc().add(doc);
		productRepository.save(p);
		
		return p;
		
	}
}
