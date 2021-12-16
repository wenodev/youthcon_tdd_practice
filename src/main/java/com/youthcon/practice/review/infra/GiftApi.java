package com.youthcon.practice.review.infra;

import com.youthcon.practice.common.CustomRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GiftApi {

    private final String url = "https://pokeapi.co/api/v2/ability/7/";

    public Boolean get(Long id){
        ResponseEntity<String> response = CustomRestTemplate.getInstance().getForEntity(url, String.class);
        return response.getStatusCode().is2xxSuccessful() ? true : false;
    }

}
