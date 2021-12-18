package com.youthcon.practice.infra;

import com.youthcon.practice.dto.SendGiftRequestDto;
import com.youthcon.practice.dto.SendGiftResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GiftApi {

    private RestTemplate restTemplate = new RestTemplate();
//    private final String URL = "http://youthcon.seok2.dev/apis/v1/send";
    private final String URL = "http://youth2323con.seok2.dev/apis/v1/send23232";

    private final Integer AMOUNT = 1000;

    public Boolean send(String phoneNumber) {
        ResponseEntity<SendGiftResponseDto> response = restTemplate.postForEntity(URL, SendGiftRequestDto.of(phoneNumber, AMOUNT), SendGiftResponseDto.class);
        return response.getStatusCode().is2xxSuccessful() ? true : false;
    }
}
