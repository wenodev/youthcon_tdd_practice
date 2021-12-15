package com.youthcon.practice;

import com.youthcon.practice.errors.GiftApiFailedException;
import com.youthcon.practice.errors.ReviewAlreadySentException;
import com.youthcon.practice.errors.ReviewNotFoundException;
import com.youthcon.practice.infra.GiftApi;
import com.youthcon.practice.infra.ReviewRepository;
import org.springframework.stereotype.Service;

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

    public Review sendGift(Long id) {
        Review review = findReview(id);
        validate(id, review);
        review.makeSentTrue();
        reviewRepository.save(review);
        return review;
    }

    private Review findReview(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("no review id : " + id));
    }

    private void validate(Long id, Review review) {
        if (review.getIsSent()){ throw new ReviewAlreadySentException(); }
        if (!giftApi.get(id)){ throw new GiftApiFailedException(); }
    }

}
