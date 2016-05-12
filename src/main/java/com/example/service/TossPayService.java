package com.example.service;

import com.example.model.TossRequest;
import com.example.model.TossResponse;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by yongjunjung on 2016. 5. 12..
 */

@Service
public class TossPayService {

    public static String PAY_REQUEST_URL = "https://toss.im/tosspay/api/v1/payments";

    RestTemplate restTemplate = new RestTemplate();

    public TossResponse postForEntityTossPayment(TossRequest request) {

        ResponseEntity<TossResponse> exchange = restTemplate.postForEntity(PAY_REQUEST_URL, request, TossResponse.class);

        TossResponse response = exchange.getBody();
        System.out.println("exchange.getStatusCode() = " + exchange.getStatusCode());
        System.out.println("response = " + response.toString());

        return response;
    }

    public TossResponse postForObjectTossPayment(TossRequest request) {

        TossResponse response = restTemplate.postForObject(PAY_REQUEST_URL, request, TossResponse.class);
        System.out.println("response = " + response.toString());

        return response;
    }


    public void tosspaySample() {
        URL url = null;
        URLConnection connection = null;
        StringBuilder responseBody = new StringBuilder();
        try {
            url = new URL("https://toss.im/tosspay/api/v1/payments");
            connection = url.openConnection();
            connection.addRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            org.json.simple.JSONObject jsonBody = new JSONObject();
            jsonBody.put("orderNo", "2015072012211");
            jsonBody.put("amount", 10000);
            jsonBody.put("productDesc", "테스트 결제");
            jsonBody.put("apiKey", "sk_test_apikey1234567890a");
            jsonBody.put("expiredTime", "2015-07-20 16:21:00");
            jsonBody.put("orderCheckCallback", "https://myshop.com/toss/orderCheck.php");
            jsonBody.put("resultCallback", "https://myshop.com/toss/result.php");

            BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
            bos.write(jsonBody.toJSONString().getBytes());
            bos.flush();
            bos.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                responseBody.append(line);
            }
            br.close();
        } catch (Exception e) {
            responseBody.append(e);
        }
        System.out.println(responseBody.toString());

    }


}
