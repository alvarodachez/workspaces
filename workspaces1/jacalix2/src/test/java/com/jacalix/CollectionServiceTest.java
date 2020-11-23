package com.jacalix;

import static org.mockito.Mockito.mock;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.jacalix.model.entity.Customer;
import com.jacalix.model.entity.Product;
import com.jacalix.repo.CustomerRepository;
import com.jacalix.repo.ProductRepository;
import com.jacalix.restService.CollectionService;

public class CollectionServiceTest {

	private CollectionService sut;
	
	private CustomerRepository mockedCustomerRepo;
	
	private ProductRepository mockedProductRepo;
	
	private Customer mockedCustomer;
	
	private Product mockedProduct;
	
	@BeforeEach
	private void init() {
		sut = new CollectionService();
		mockedCustomer = mock(Customer.class);
		mockedProduct = mock(Product.class);
		
		mockedCustomerRepo = mock(CustomerRepository.class);
		mockedProductRepo = mock(ProductRepository.class);
		
		sut.setCr(mockedCustomerRepo);
		sut.setPr(mockedProductRepo);
	}
	
	@Test
	public void createCustomer() {
		
		
		
		Mockito.when(mockedCustomerRepo.findById(Mockito.any())).thenReturn(Optional.of(mockedCustomer));
		
		
		
	}
	
}
