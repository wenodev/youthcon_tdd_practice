package com.youthcon.practice;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;


class ReviewServiceTest {
    private GiftApi giftApi = mock(GiftApi.class);
    private ReviewRepository reviewRepository = mock(ReviewRepository.class);
    private ReviewService reviewService = new ReviewService(reviewRepository, giftApi);

    private final Long id = 1L;
    private final String content = "재밌어요";
    private final String phoneNumber = "010-1111-2222";


    @Test
    void 후기_조회_성공(){
        // 준비
        given(reviewRepository.findById(id)).willReturn( Optional.of(new Review(id, content, phoneNumber)));

        // 실행
        Review review = reviewService.getById(id);

        // 검증
        assertThat(review.getId()).isEqualTo(id);
        assertThat(review.getContent()).isEqualTo(content);
        assertThat(review.getPhoneNumber()).isEqualTo(phoneNumber);
    }

    @Test
    void 선물하기(){
        // 준비
        /*
        1. 디비에서 값 꺼내오기 -> 선물안한 리뷰
        2. 선물하기
        3. 리뷰 상태값 변경
         */
        given(reviewRepository.findById(id)).willReturn(Optional.of(new Review(id, content, phoneNumber, false)));
        given(giftApi.get(id)).willReturn(true);
        given(reviewRepository.save(any(Review.class))).willReturn(new Review(id, content, phoneNumber, true));

        // 실행
        Review review = reviewService.sendGift(id);

        // 검증
        assertThat(review.getIsSent()).isEqualTo(true);
    }

}