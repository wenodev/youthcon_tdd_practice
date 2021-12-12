package com.youthcon.start;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class ReviewServiceTest {

    ReviewRepository reviewRepository = mock(ReviewRepository.class);
    ReviewService reviewService = new ReviewService(reviewRepository);

    @Test
    void 후기_생성_100글자_이상_후기_리턴(){
        // 준비
        String content = "1별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요";
        String phoneNumber = "010-1234-1234";
        given(reviewRepository.save(any(Review.class))).willReturn(new Review(content, phoneNumber));

        // 실행
        Review review = reviewService.create(content, phoneNumber);

        // 검증
        assertThat(review.getContent()).isEqualTo(content);
    }

    @Test
    void 후기_생성_100글자_이하_예외_발생(){
        // 준비
        String content = "별로";
        String phoneNumber = "010-1234-1234";

        assertThatThrownBy(()->
                given(reviewRepository.save(any(Review.class))).willReturn(new Review(content, phoneNumber)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->
                // 실행
                 reviewService.create(content, phoneNumber))

                // 검증
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 후기_수정_100글자_이상_후기_리턴(){
        // 준비
        String content = "1별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요";
        String changedContent = "별로";

        String phoneNumber = "010-1234-1234";
        given(reviewRepository.findById(1L)).willReturn(Optional.of(new Review(content, phoneNumber)));
        given(reviewRepository.save(any(Review.class))).willReturn(new Review(changedContent, phoneNumber));

        // 실행
        Review review = reviewService.changeContent(changedContent)

        // 검증
        assertThat(review.getContent()).isEqualTo(content);
    }

}
