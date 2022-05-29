package com.sb_tdd;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sb_tdd.model.Car;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AppMainTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void getCar_should_return_http_200_given_valid_url()  throws Exception{
		// Add a test car before testing
		//testRestTemplate.postForEntity("/cars", new Car("prius", "hybrid"), Car.class);
		ResponseEntity<Car> carResponse = testRestTemplate.getForEntity("/cars/prius", Car.class);
		assertThat(carResponse).extracting(ResponseEntity::getStatusCode).isEqualTo(HttpStatus.OK);
		
		
		Car car = new Car("prius", "hybrid");
		assertThat(car).extracting(Car::getName).isEqualTo("prius");
		assertThat(car).extracting(Car::getType).isEqualTo("hybrid");
		
	}

}


