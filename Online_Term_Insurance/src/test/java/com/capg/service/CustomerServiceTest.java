package com.capg.service;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.entity.Customer;
import com.capg.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerServiceTest {

	@Autowired
	private CustomerServiceImpl service;
	
	@MockBean
	private CustomerRepository repository;
	
//	@Test
//	void contextLoads() {
//	}
	@Test
	public void getCustomersTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Customer(456,"ray","Indore",45,4566,"8085301689","Male","4", "dsad@gmail.com","sda123456")).collect(Collectors.toList()));
		assertEquals(1,service.getCustomers().size());
	}
	@Test
	public void addCustomerTest() {
		Customer customer = new Customer(100,"Trax","KIndore",45,4566,"8085401689","Male","4", "Kigngo@gmail.com","sdaa654789");
		when(repository.save(customer)).thenReturn(customer);
		assertEquals(customer, service.addCustomer(customer));
	}
//	@Test
//	public void deleteCustomerTest() {
//		Customer customer = new Customer(100,"Trax","KIndore",45,4566,"8085401689","Male","4", "Kigngo@gmail.com","sdaa");
//		service.deleteCustomer(customer);
//		verify(repository, times(1)).delete(customer);
//	}
}
