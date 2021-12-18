package com.youthcon.practice.errors;

public class SendGiftInternalException extends RuntimeException {
    public SendGiftInternalException(String message) {
        super(message);
    }
}
