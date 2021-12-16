package com.youthcon.practice.review.errors;

public class GiftApiFailedException extends RuntimeException {
    public GiftApiFailedException(String message) {
        super(message);
    }
}
