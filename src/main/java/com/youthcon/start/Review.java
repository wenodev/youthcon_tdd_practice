package com.youthcon.start;

public class Review {

    private String content;
    private String phoneNumber;

    public Review(String content, String phoneNumber) {
        validateContent(content);

        this.content = content;
        this.phoneNumber = phoneNumber;
    }

    public String getContent() {
        return this.content;
    }

    public void changeContent(String content) {
        validateContent(content);
        this.content = content;
    }

    private void validateContent(String content) {
        if (content.length() < 100){
            throw new IllegalArgumentException();
        }
    }
}
