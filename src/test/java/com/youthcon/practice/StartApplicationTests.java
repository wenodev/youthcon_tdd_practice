package com.youthcon.practice;

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
*후기 조회 하기 API*
- [ ] 후기의 ID를 요청 값으로 받습니다.
- [ ] 요청 ID에 대한 후기를 찾아 응답값으로 내려줍니다. (200 OK)
- [ ] 응답에는 반드시 본문과 연락처를 포함해야 합니다.
- [ ] 후기가 존재하지 않는다면 에러를 응답해야 합니다. (404 Not Found)

*후기 작성자에게 선물하기 API*
- [ ] 후기의 ID를 요청 값으로 받습니다.
- [ ] 선물은 후기당 한번만 요청 할 수 있습니다.
- [ ] 선물하기에 성공하면 후기의 현재 상태를 응답합니다. (200 OK)
- [ ] 선물하기는 아래의 API를 호출하여 수행합니다.
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
    void 후기_조회_성공(){
        // 준비, arrange, given
        given()
                .accept(MediaType.APPLICATION_JSON_VALUE)
        // 실행, act, when
        .when()
                .get("/reviews/1")
        // 검증, assert, then
        .then()
                .statusCode(HttpStatus.OK.value())
                .assertThat().body("id", equalTo(1))
                .assertThat().body("content", equalTo("재밌어요"))
                .assertThat().body("phoneNumber", equalTo("010-1111-2222"));
    }

    @Test
    void 후기_조회_실패(){
        assert false;
    }

    @Test
    void 선물하기(){
        assert false;
    }

}
