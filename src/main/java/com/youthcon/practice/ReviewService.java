package com.youthcon.practice;

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
        return findReview(id);
    }

    @Transactional
    public Review sendGift(Long id) {
        Review review = findReview(id);
        if (review.getIsSent()){throw new DuplicateSendGift("failed gift api get method"); }
        if (!giftApi.get(id)){ throw new GiftGetFailedException("failed gift api get method"); }
        review.makeSentTrue();
        return reviewRepository.save(review);
    }

    private Review findReview(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("no review id : " + id));
    }

}
