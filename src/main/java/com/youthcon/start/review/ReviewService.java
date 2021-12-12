package com.youthcon.start.review;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review create(Review review){
        return reviewRepository.save(review);
    }

}
