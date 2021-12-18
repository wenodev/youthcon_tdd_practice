package com.youthcon.practice.application;

import com.youthcon.practice.domain.Review;
import com.youthcon.practice.errors.DuplicateSendGiftException;
import com.youthcon.practice.errors.ReviewNotFoundException;
import com.youthcon.practice.errors.SendGiftInternalException;
import com.youthcon.practice.infra.GiftApi;
import com.youthcon.practice.infra.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final GiftApi giftApi;

    public ReviewService(ReviewRepository reviewRepository, GiftApi giftApi) {
        this.reviewRepository = reviewRepository;
        this.giftApi = giftApi;
    }

    @Transactional(readOnly = true)
    public Review getById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("no review id : " + id));
    }

    @Transactional
    public Review sendGift(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("no review id : " + id));

        if (review.getIsSent()){
            throw new DuplicateSendGiftException("review id : " + id);
        }

        if (!giftApi.send(review.getPhoneNumber())){
            throw new SendGiftInternalException("review phoneNumber : " + review.getPhoneNumber());
        }

        review.makeTrue();

        return review;
    }
}
