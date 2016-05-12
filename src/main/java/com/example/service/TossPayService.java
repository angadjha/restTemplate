package com.example.service;

import com.example.model.TossRequest;
import com.example.model.TossResponse;
import com.example.util.QueryParamGenerator;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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

    QueryParamGenerator queryParamGenerator = new QueryParamGenerator();

    public TossResponse postForEntityTossPayment(TossRequest request) {

        ResponseEntity<TossResponse> tossResponseResponseEntity = restTemplate.postForEntity(PAY_REQUEST_URL, request, TossResponse.class);

        TossResponse response = tossResponseResponseEntity.getBody();
        System.out.println("exchange.getStatusCode() = " + tossResponseResponseEntity.getStatusCode());
        System.out.println("response = " + response.toString());

        return response;
    }

    public TossResponse postForObjectTossPayment(TossRequest request) {

        TossResponse response = restTemplate.postForObject(PAY_REQUEST_URL, request, TossResponse.class);
        System.out.println("response = " + response.toString());

        return response;
    }

    public TossResponse exchangeTossPayment(TossRequest request) {

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(PAY_REQUEST_URL)
                .queryParams(queryParamGenerator.generate(request))
                .build();

        ResponseEntity<TossResponse> exchange = restTemplate.exchange(uriComponents.toUri(), HttpMethod.POST, HttpEntity.EMPTY, TossResponse.class);

        HttpStatus statusCode = exchange.getStatusCode();
        TossResponse response = exchange.getBody();

        System.out.println("statusCode = " + statusCode);
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
