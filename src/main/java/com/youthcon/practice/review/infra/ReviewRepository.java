package com.youthcon.practice.review.infra;

import com.youthcon.practice.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
