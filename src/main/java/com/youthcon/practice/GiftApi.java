package com.youthcon.practice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GiftApi {
    private  final String url ="https://pokeapi.co/api/v2/ability/7";

    public Boolean get(Long id){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getStatusCode().is2xxSuccessful() ? true : false;
    }

}
