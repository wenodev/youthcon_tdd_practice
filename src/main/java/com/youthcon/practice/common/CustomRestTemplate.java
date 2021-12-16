package com.youthcon.practice.common;

import org.springframework.web.client.RestTemplate;

public class CustomRestTemplate {

    private static RestTemplate restTemplate;

    public static RestTemplate getInstance(){
        if (restTemplate == null){
            restTemplate = new RestTemplate();
        }
        return restTemplate;
    }

}
