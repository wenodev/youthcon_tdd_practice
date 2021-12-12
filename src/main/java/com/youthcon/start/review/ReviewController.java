package com.youthcon.start.review;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews/{id}")
    public Review getById(@PathVariable Long id){
        return reviewService.getById(id);
    }

    @PostMapping("/reviews")
    public Review create(@RequestBody Review review){
        return reviewService.create(review);
    }

    @PutMapping("/reviews/confirm")
    public Boolean update(@PathVariable Long id) throws IOException {
        return reviewService.update(id);
    }

}
