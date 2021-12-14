package com.youthcon.start;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class ReviewServiceTest {
    ReviewRepository reviewRepository = mock(ReviewRepository.class);
    ReviewService reviewService = new ReviewService(reviewRepository);

    private final Long existedId = 2L;
    private final String content = "재밌어요!";

    @Test
    void 후기_조회(){
        // 준비
        given(reviewRepository.findById(existedId)).willReturn(Optional.of(new Review(existedId, content)));

        // 실행
        Review review = reviewService.getById(existedId);

        // 실행
        assertThat(review.getId()).isEqualTo(2);
        assertThat(review.getContent()).isEqualTo(content);
    }

}
