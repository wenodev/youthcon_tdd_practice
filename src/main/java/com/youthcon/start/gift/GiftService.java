package com.youthcon.start.gift;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Transactional
@Service
public class GiftService {

    private static final String URL = "https://www.google.com";
    private static final String POST = "POST";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String DATA = "gift";

    private final GiftRepository giftRepository;

    public GiftService(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    public Boolean proceed(Gift gift) throws IOException {
        java.net.URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod(POST);
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setDoOutput(true);

        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(DATA);
        outputStream.flush();
        outputStream.close();

        int responseCode = connection.getResponseCode();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String inputLine;

        while ((inputLine = bufferedReader.readLine()) != null)  {
            stringBuffer.append(inputLine);
        }
        bufferedReader.close();

        String response = stringBuffer.toString();

        if (response.contains("success")){
            giftRepository.save(Gift.builder()
                            .couponName(gift.getCouponName())
                            .phoneNumber(gift.getPhoneNumber())
                            .isDone(true)
                    .build());

            return true;
        }else{
            giftRepository.save(Gift.builder()
                    .couponName(gift.getCouponName())
                    .phoneNumber(gift.getPhoneNumber())
                    .isDone(false)
                    .build());

            return false;
        }

    }
}
