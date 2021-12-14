package com.youthcon.start;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp(){
        RestAssured.port = port;
    }

    @Test
    void 후기_조회(){
        given()
                .accept(MediaType.APPLICATION_JSON_VALUE)
        .when()
                .get("/reviews/3")
        .then()
                .statusCode(HttpStatus.OK.value())
                .assertThat().body("id", equalTo(1))
                .assertThat().body("content", equalTo("good"));
    }

    @Test
    void 쿠폰_선물(){

    }

}
