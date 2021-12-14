package com.youthcon.start;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReviewServiceTest {
    ReviewRepository reviewRepository;
    ReviewService reviewService = new ReviewService();

    @Test
    void 후기_조회(){
        // ㅁ

        // ㅁ
        Review review = reviewService.getById(1L);

        // ㅁ
        assertThat(review.getId()).isEqualTo(1);
        assertThat(review.getContent()).isEqualTo("재밌어요");
    }

}
