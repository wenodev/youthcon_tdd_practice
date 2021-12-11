package com.youthcon.start;

import org.junit.jupiter.api.Test;

public class ReviewTest {

    @Test
    void create_review(){
        Review review = new Review("너무 재미있어요.", "010-1234-1234");

        review.getContent() == "너무 재미 있어요"
    }

}
