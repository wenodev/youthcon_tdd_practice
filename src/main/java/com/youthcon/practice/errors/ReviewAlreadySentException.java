package com.youthcon.practice.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReviewAlreadySentException extends RuntimeException {
    public ReviewAlreadySentException(){
    }
}
