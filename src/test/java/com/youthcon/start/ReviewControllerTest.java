package com.youthcon.start;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    @Test
    void 후기_조회() throws Exception {
        // 준비
        given(reviewService.getById(1L)).willReturn(Review.builder().content("재밌어요").build());

        // 실행
        ResultActions actions = mockMvc.perform(get("/reviews/1"));

        // 검증
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("content").value("재밌어요"));
    }

}
