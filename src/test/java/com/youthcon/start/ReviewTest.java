package com.youthcon.start;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReviewTest {

    @Test
    void create_review(){
        Review review = new Review("별로에요", "010-1234-1234");

        assertThat(review.getContent()).isEqualTo("별로에요");
    }

}
