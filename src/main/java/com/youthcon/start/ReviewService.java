package com.youthcon.start;

public class ReviewService {
    public Review create(String content, String phoneNumber) {
        return new Review(content, phoneNumber);
    }
}
