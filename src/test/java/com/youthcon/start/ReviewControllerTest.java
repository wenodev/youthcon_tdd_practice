package com.youthcon.start;

import com.youthcon.start.review.Review;
import com.youthcon.start.review.ReviewController;
import com.youthcon.start.review.ReviewService;
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
class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    private final Long existedId = 1L;
    private final String existedContent = "재밌어요!";

    @Test
    public void 후기_조회() throws Exception {
        // 준비
        given(reviewService.getById(existedId))
                .willReturn(Review.builder()
                        .content(existedContent).build());

        // 실행
        ResultActions resultActions = mockMvc.perform(get("/reviews/" + existedId ));

        // 검증
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("content").value(existedContent));
    }

}