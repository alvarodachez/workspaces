package com.jacalix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

		Mockito.when(mockedCustomerRepo.save(Mockito.any())).thenReturn(null);
		Mockito.when(sut.createCustomer(Mockito.any())).thenReturn(mockedCustomer);

		assert (mockedCustomer == sut.createCustomer(mockedCustomer));

	}

	@Test
	public void createProduct() {
		Mockito.when(mockedProductRepo.save(Mockito.any())).thenReturn(null);
		Mockito.when(sut.createProduct(Mockito.any())).thenReturn(mockedProduct);

		assert (mockedProduct == sut.createProduct(mockedProduct));
	}

	@ParameterizedTest
	@MethodSource("updateCustomerDataProvider")
	public void updateCustomer(Customer arg, Customer res) {
		Mockito.when(mockedCustomerRepo.findById(Mockito.any())).thenReturn(Optional.of(mockedCustomer));
		assertEquals(sut.updateCustomer(arg, 1).getName(), res.getName());
		assertEquals(sut.updateCustomer(arg, 1).getSurname(), res.getSurname());

	}

	private static Stream<Arguments> updateCustomerDataProvider() {
		Customer correctUpdate = mock(Customer.class);
		correctUpdate.setName("nombre");
		correctUpdate.setSurname("apellidos");
		correctUpdate.setAge(20);
		correctUpdate.setDni("dni");

		Customer nullUpdate = mock(Customer.class);
		correctUpdate.setName(null);
		correctUpdate.setSurname(null);
		correctUpdate.setAge(0);
		correctUpdate.setDni(null);
		return Stream.of(Arguments.of(correctUpdate, correctUpdate));
	}

}
