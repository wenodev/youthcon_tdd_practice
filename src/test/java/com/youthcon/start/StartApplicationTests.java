package com.youthcon.start;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StartApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void hello(){
		// 실행
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("/hello", String.class);

		// 검증
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).contains("youth");
	}

}
