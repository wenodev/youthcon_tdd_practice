package com.youthcon.practice.review.errors;

public class DuplicateSendGiftException extends RuntimeException {
    public DuplicateSendGiftException(String message) {
        super(message);
    }
}
