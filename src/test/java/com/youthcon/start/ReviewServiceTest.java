package com.youthcon.start;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ReviewServiceTest {

    private ReviewRepository reviewRepository = mock(ReviewRepository.class);
    private ReviewService reviewService = new ReviewService(reviewRepository);

    @Test
    void 후기_조회(){
        // 준비
        given(reviewRepository.findById(1L))
                .willReturn(Optional.of(Review.builder().content("재밌어요").build()));

        // 실행
        Review review = reviewService.getById(1L);

        // 검증
        assertThat(review.getContent()).isEqualTo("재밌어요");
    }
}
