package com.youthcon.start;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ReviewServiceTest {

    ReviewRepository reviewRepository = mock(ReviewRepository.class);
    ReviewService reviewService = new ReviewService(reviewRepository);

    private final Long existedId = 3L;
    private final String existedContent = "good!!";

    @Test
    void 후기_조회(){
        // 준비
        org.mockito.BDDMockito.given(reviewRepository.findById(existedId)).willReturn(Optional.of(new Review(existedId, existedContent)));

        // 실행
        Review review = reviewService.getById(existedId);

        // 검증
        assertThat(review.getContent()).isEqualTo(existedContent);
    }
}
