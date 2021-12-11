package com.youthcon.start;

public class Review {

    private String content;
    private String phoneNumber;

    public Review(String content, String phoneNumber) {
        this.content = content;
        this.phoneNumber = phoneNumber;
    }

    public String getContent() {
        return this.content;
    }
}
