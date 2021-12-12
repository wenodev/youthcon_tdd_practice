package com.youthcon.start;

public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review create(String content, String phoneNumber) {
        return reviewRepository.save(new Review(content, phoneNumber));
    }
}
