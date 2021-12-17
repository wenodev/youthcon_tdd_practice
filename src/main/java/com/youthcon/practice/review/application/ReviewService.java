package com.youthcon.practice.review.application;

import com.youthcon.practice.review.domain.Review;
import com.youthcon.practice.review.errors.DuplicateSendGiftException;
import com.youthcon.practice.review.errors.GiftApiFailedException;
import com.youthcon.practice.review.errors.ReviewNotFoundException;
import com.youthcon.practice.review.infra.GiftApi;
import com.youthcon.practice.review.infra.ReviewRepository;
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

    public Review getById(Long id) {
        return findReview(id);
    }

    @Transactional
    public Review sendGift(Long id) {
        Review review = reviewRepository.findById(id)
                .filter(it -> !it.getIsSent())
                .orElseThrow(() -> new DuplicateSendGiftException("duplicate send gift review id : " + id));
        review.makeTrue(giftApi.send(review.getPhoneNumber()));
        return review;
    }

//    private void validateGiftApi(Long id) {
//        if (!giftApi.send(id)){
//            throw new GiftApiFailedException("duplicate send gift review id : " + id);
//        }
//    }
//
//    private void validateDuplicateSendGift(Review review) {
//        if (review.getIsSent()){
//            throw new DuplicateSendGiftException("duplicate send gift review id : " + review.getId());
//        }
//    }

    private Review findReview(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new ReviewNotFoundException("no review id : " + id));
    }

}
