package com.youthcon.practice.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GiftApiFailedException extends RuntimeException {
    public GiftApiFailedException(){
    }
}
