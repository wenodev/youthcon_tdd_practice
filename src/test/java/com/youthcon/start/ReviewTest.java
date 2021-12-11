package com.youthcon.start;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ReviewTest {

    @Test
    void 후기가_100글자_이상이면_생성된다(){
        // 준비
        String content = "별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요";
        String phoneNumber = "010-1234-1234";

        // 실행
        Review review = new Review(content, phoneNumber);

        // 검증
        assertThat(review.getContent()).isEqualTo(content);
    }

    @Test
    void 후기가_100글자_미만이면_예외가_발생한다(){
        // 준비
        String content = "별로";
        String phoneNumber = "010-1234-1234";

        assertThatThrownBy(() ->
                // 실행
                new Review(content, phoneNumber))

                // 검증
                .isInstanceOf(IllegalArgumentException.class);
    }

}
