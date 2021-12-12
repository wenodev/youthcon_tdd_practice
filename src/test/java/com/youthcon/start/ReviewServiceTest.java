package com.youthcon.start;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ReviewServiceTest {

    private ReviewRepository reviewRepository;
    ReviewService reviewService = new ReviewService(reviewRepository);

    @Test
    void 후기_생성_100글자_이상_후기_리턴(){
        // 준비
        String content = "1별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요";
        String phoneNumber = "010-1234-1234";
        reviewRepository.save();

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
                // 실행
                 reviewService.create(content, phoneNumber))

                // 검증
                .isInstanceOf(IllegalArgumentException.class);
    }
}
