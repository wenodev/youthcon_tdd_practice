package com.youthcon.practice.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GiftApi {

    private final static String giftUrl = "https://pokeapi.co/api/v2/ability/7/";

    public boolean get(Long id){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(giftUrl, String.class);
        return response.getStatusCode().is2xxSuccessful() ? true : false;
    }

}
