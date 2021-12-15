package com.youthcon.practice.infra;

import com.youthcon.practice.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
