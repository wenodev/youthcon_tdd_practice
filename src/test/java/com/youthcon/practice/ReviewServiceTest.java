package com.youthcon.practice;

import com.youthcon.practice.application.ReviewService;
import com.youthcon.practice.domain.Review;
import com.youthcon.practice.errors.ReviewNotFoundException;
import com.youthcon.practice.infra.GiftApi;
import com.youthcon.practice.infra.ReviewRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ReviewServiceTest {

    private GiftApi giftApi = mock(GiftApi.class);
    private ReviewRepository reviewRepository = mock(ReviewRepository.class);
    private ReviewService reviewService = new ReviewService(reviewRepository, giftApi);

    private Long id = 2L;
    private String  content = "재밌어요!";
    private String phoneNumber = "010-1111-2223";

    @Test
    void 후기_조회_성공(){
        // 준비
        given(reviewRepository.findById(id)).willReturn(Optional.of(new Review(id, content, phoneNumber)));

        // 실행
        Review review = reviewService.getById(id);

        // 검증
        assertThat(review.getId()).isEqualTo(id);
        assertThat(review.getContent()).isEqualTo(content);
        assertThat(review.getPhoneNumber()).isEqualTo(phoneNumber);
    }

    @Test
    void 후기_조회_실패(){
        assertThatThrownBy(() ->
                // 실행
                reviewService.getById(1000L))
                // 검증
                .isInstanceOf(ReviewNotFoundException.class);
    }

    @Test
    void 선물하기(){
        // 준비
        given(reviewRepository.findById(id)).willReturn(Optional.of(new Review(id, content, phoneNumber, false)));
        given(giftApi.send(phoneNumber)).willReturn(true);
        given(reviewRepository.save(any(Review.class))).willReturn(new Review(id, content, phoneNumber, true));

        //실행
        Review review = reviewService.sendGift(id);

        // 검증
        assertThat(review.getId()).isEqualTo(id);
        assertThat(review.getIsSent()).isEqualTo(true);
    }
}
