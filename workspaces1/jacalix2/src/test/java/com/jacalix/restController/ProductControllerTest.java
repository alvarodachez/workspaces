package com.jacalix.restController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jacalix.model.entity.Product;
import com.jacalix.repo.CustomerRepository;
import com.jacalix.repo.DocumentRepository;
import com.jacalix.repo.ProductRepository;
import com.jacalix.repo.SubscriptionRepository;
import com.jacalix.repo.ViewRepository;
import com.jacalix.restService.CollectionService;
import com.jacalix.restService.CompressService;
import com.jacalix.restService.ProductService;



@MockBean(value = {
		ProductService.class,
		CompressService.class,
		ViewRepository.class,
		DocumentRepository.class,
		CustomerRepository.class,
		SubscriptionRepository.class
		   })

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMVC;
	
	@MockBean
	private ProductRepository pRepository;

	@MockBean
	private CollectionService service; 
	
	private final static String ROOT_PATH = "/jacalix/products";
	
	@BeforeTestExecution
	private void init() {
		
	}
	
	@Test
	public void getProducts() throws Exception {
		mockMVC.perform(get(ROOT_PATH)).andExpect(status().isOk());
	}
	
	@ParameterizedTest
	@MethodSource("postDataProvider")
	public void postProduct(Integer id, ResultMatcher expectedResult) throws Exception {
		Product mockProduct = Mockito.mock(Product.class);
		Mockito.when(mockProduct.getId()).thenReturn(id);
		Mockito.when(pRepository.save(Mockito.any())).thenReturn(mockProduct);
		
		mockMVC.perform(MockMvcRequestBuilders.post(ROOT_PATH)
							.accept(MediaType.APPLICATION_JSON_VALUE)
							.contentType(MediaType.APPLICATION_JSON_VALUE)
							.content("{\"name\":\"\", \"description\":\"\", \"rent\":\"GOLD\"}"))
		.andExpect(expectedResult);
	}
	
	private static Stream<Arguments> postDataProvider(){
		return Stream.of(
						Arguments.of(Integer.valueOf(3), status().is2xxSuccessful()),
						Arguments.of(Integer.valueOf(15), status().isCreated())
					);
	}
}
