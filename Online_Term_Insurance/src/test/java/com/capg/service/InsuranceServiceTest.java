package com.capg.service;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.capg.entity.Customer;
import com.capg.entity.Insurance;
import com.capg.repository.InsuranceRepository;
import com.capg.service.CustomerServiceImpl;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class InsuranceServiceTest {

	@Autowired
	private InsuranceServiceImpl service;
	
	@MockBean
	private InsuranceRepository repository;
	

	@Test
	public void getInsuranceTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Insurance(68,"ICICI Prudential",454566,"1200",4)).collect(Collectors.toList()));
		assertEquals(1,service.getInsurances().size());
	}
	@Test
	public void addInsuranceTest() {
		Insurance insurance = new Insurance(45,"AXIS life",120000,"4566",5);
		when(repository.save(insurance)).thenReturn(insurance);
		assertEquals(insurance, service.addInsurance(insurance));
	}
	
}



