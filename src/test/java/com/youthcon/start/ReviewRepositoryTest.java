package com.youthcon.start;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ReviewRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ReviewRepository reviewRepository;

    @BeforeEach
    void setUp(){
        Review review = new Review(1L, "재밌어요");
        testEntityManager.persist(review);
    }

    @Test
    void 후기_조회(){
        // a

        // a
        Review review = reviewRepository.findById(1L)
                .orElseThrow(RuntimeException::new);

        // a
        assertThat(review.getId()).isEqualTo(1);
        assertThat(review.getContent()).isEqualTo("재밌어요");
    }

}