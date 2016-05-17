package com.example.service;

import com.example.model.ReceiptRequest;
import com.example.model.ReceiptResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yongjunjung on 2016. 5. 17..
 */

@Service
public class RestGetService {

    public static String ACCESS_TOKEN = "e7f1970b-68f2-4168-b128-b1239589af08";

    RestTemplate restTemplate = new RestTemplate();

    public ReceiptResponse getForObjectReceipt(ReceiptRequest request) {

        String RECEIPT_REQUEST_URL = getURLString(request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + ACCESS_TOKEN);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<ReceiptResponse> exchange = restTemplate.exchange(RECEIPT_REQUEST_URL, HttpMethod.GET, entity, ReceiptResponse.class);
        ReceiptResponse response = exchange.getBody();

        return response;
    }

    private String getURLString(ReceiptRequest request) {
        return "http://dev-billing-api.baemin.com/receipts/" + request.getServiceId() + "/" + request.getServiceTradeNo();
    }

}
