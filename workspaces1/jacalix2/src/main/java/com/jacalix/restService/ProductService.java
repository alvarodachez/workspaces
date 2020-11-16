package com.jacalix.restService;

import java.sql.SQLException;

import javax.print.attribute.standard.PDLOverrideSupported;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jacalix.model.entity.Document;
import com.jacalix.model.entity.Product;
import com.jacalix.repo.DocumentRepository;
import com.jacalix.repo.ProductRepository;

@Service
public class ProductService extends AbstractServiceUtils {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private FileHandlerService fhService;

	public Product addDocument(MultipartFile mpf, Integer id) {
		Product p = null;

		try {
			Document doc = documentRepository.save(new Document(fhService.createBlob(mpf), mpf.getName(),
					mpf.getContentType(), Integer.valueOf((int) mpf.getSize())));

			p = productRepository.findById(id).get();
			p.setDoc(doc);
			productRepository.save(p);
		} catch (NumberFormatException e) {
			logger.debug(String.format("Customer with identifier %s could not be found ", id));
		}

		return p;

	}

	public ResponseEntity<byte[]> getDocument(Integer id) throws SQLException {
		Product p = productRepository.findById(id).get();

		Document file = documentRepository.findById(p.getDoc().getId()).get();

		return ResponseEntity.ok().header("hola", "attachment; filename=\"" + file.getFileName() + "\"")
				.body(file.getPicture().getBytes(1L, (int) file.getPicture().length()));
	}

	public ResponseEntity<Resource> downloadDocument(Integer id) throws SQLException {
		Product p = productRepository.findById(id).get();
		Document d = documentRepository.findById(p.getDoc().getId()).get();

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(d.getFileType()))
				.header("hola", "attachment; filename=\"" + d.getFileName() + "\"")
				.body(new ByteArrayResource(d.getPicture().getBytes(1L, (int) d.getPicture().length())));
	}
}
