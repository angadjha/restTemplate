package com.example.service;

import com.example.model.ReceiptRequest;
import com.example.model.ReceiptResponse;
import com.example.util.QueryParamGenerator;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by yongjunjung on 2016. 5. 17..
 */

@Service
public class RestGetService {

    public static String ACCESS_TOKEN = "e7f1970b-68f2-4168-b128-b1239589af08";

    RestTemplate restTemplate = new RestTemplate();
    QueryParamGenerator generator = new QueryParamGenerator();

    public ReceiptResponse getExchange(ReceiptRequest request) {

        String RECEIPT_REQUEST_URL = "http://dev-billing-api.baemin.com/receipts/" + request.getServiceId() + "/" + request.getServiceTradeNo();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + ACCESS_TOKEN);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<ReceiptResponse> exchange = restTemplate.exchange(RECEIPT_REQUEST_URL, HttpMethod.GET, entity, ReceiptResponse.class);
        ReceiptResponse response = exchange.getBody();

        return response;
    }

    public ReceiptResponse getForObject(ReceiptRequest request) {

        UriComponents uriComponents = getUriComponents(request);
        System.out.println("uriComponents = " + uriComponents.toString());

        ReceiptResponse response = restTemplate.getForObject(uriComponents.toString(), ReceiptResponse.class);

        return response;
    }

    public ReceiptResponse getForEntity(ReceiptRequest request) {

        UriComponents uriComponents = getUriComponents(request);
        System.out.println("uriComponents = " + uriComponents.toString());

        ResponseEntity<ReceiptResponse> entity = restTemplate.getForEntity(uriComponents.toString(), ReceiptResponse.class);
        ReceiptResponse response = entity.getBody();

        System.out.println("entity.getHeaders() = " + entity.getHeaders());

        return response;
    }

    private UriComponents getUriComponents(ReceiptRequest request) {
        String RECEIPT_REQUEST_URL = "http://dev-billing-api.baemin.com/test/receipts";

        return UriComponentsBuilder.fromHttpUrl(RECEIPT_REQUEST_URL)
                .queryParams(generator.generate(request))
                .build();
    }
}
