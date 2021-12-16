package com.youthcon.practice.common;

import com.youthcon.practice.review.errors.DuplicateSendGiftException;
import com.youthcon.practice.review.errors.GiftApiFailedException;
import com.youthcon.practice.review.errors.ReviewNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicateSendGiftException.class)
    public String handleDuplicateSendGiftException(DuplicateSendGiftException ex){
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(GiftApiFailedException.class)
    public String handleGifApiFailedException(GiftApiFailedException ex){
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ReviewNotFoundException.class)
    public String handleReviewNotFoundException(ReviewNotFoundException ex){
        return ex.getMessage();
    }

}
