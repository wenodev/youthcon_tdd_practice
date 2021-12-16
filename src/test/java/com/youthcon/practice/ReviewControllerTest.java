package com.youthcon.practice;

import com.youthcon.practice.review.application.ReviewService;
import com.youthcon.practice.review.domain.Review;
import com.youthcon.practice.review.ui.ReviewController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ReviewService reviewService;

    private final Long id = 1L;
    private final String content = "재밌어요";
    private final String phoneNumber = "010-1111-2222";

    @Test
    void 후기_조회_성공() throws Exception {
        // 준비
        given(reviewService.getById(id)).willReturn(new Review(id, content, phoneNumber));

        // 실행
        ResultActions resultActions = mockMvc.perform(get("/reviews/" + id));

        // 검증
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(id))
                .andExpect(jsonPath("content").value(content))
                .andExpect(jsonPath("phoneNumber").value(phoneNumber));
    }

    @Test
    void 선물하기() throws Exception {
        // 준비
        given(reviewService.sendGift(id)).willReturn(new Review(id, content, phoneNumber, true));

        // 실행
        ResultActions resultActions = mockMvc.perform(put("/reviews/" + id));

        // 검증
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(id))
                .andExpect(jsonPath("content").value(content))
                .andExpect(jsonPath("phoneNumber").value(phoneNumber))
                .andExpect(jsonPath("isSent").value(true));
    }

}