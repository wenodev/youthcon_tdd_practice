package com.youthcon.practice.errors;

public class DuplicateSendGiftException extends RuntimeException {
    public DuplicateSendGiftException(String message) {
        super(message);
    }
}
