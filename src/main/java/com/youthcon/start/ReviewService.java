package com.youthcon.start;

import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review getById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

}
