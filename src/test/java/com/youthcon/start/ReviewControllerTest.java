package com.youthcon.start;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    private final Long existedId = 2L;
    private final String content = "재밌어요!";

    @Test
    void 후기_조회() throws Exception {
        given(reviewService.getById(existedId)).willReturn(new Review(existedId, content));

        mockMvc.perform(get("/reviews/" + existedId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(existedId))
                .andExpect(jsonPath("content").value(content));
    }

}
