package com.youthcon.start;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/*
시나리오
- 리뷰를 조회할 수 있게 해주세요.
- 리뷰 작성작에게 배민 선물하기 기능 추가해주세요.

요구사항
- 유스콘 참석자의 후기를 조회 할 수 있다.
- 관리자는 후기를 보고 배달의 민족 쿠폰을 선물 할 수 있다.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StartApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void 후기_조회(){
		ResponseEntity<Review> response = restTemplate.getForEntity("/reviews/1", Review.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
