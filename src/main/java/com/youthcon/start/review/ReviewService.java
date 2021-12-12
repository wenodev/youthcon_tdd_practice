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

    public Review getById(Long id) {
        return reviewRepository.findById(id).orElseThrow(()-> new ReviewNotFoundException("no review id : " + id));
    }

    public Review confirm(Long id) {
        return null;
    }
}
