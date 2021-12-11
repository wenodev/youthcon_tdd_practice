package com.youthcon.start;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ReviewTest {

    @Test
    void 후기가_100글자_이상이면_생성된다(){
        String content = "별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요";
        String phoneNumber = "010-1234-1234";

        Review review = new Review(content, phoneNumber);

        assertThat(review.getContent()).isEqualTo(content);
    }

    @Test
    void 후기가_100글자_미만이면_예외가_발생한다(){
        String content = "별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요별로에요";
        String phoneNumber = "010-1234-1234";

        assertThatThrownBy(() ->
                new Review(content, phoneNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
