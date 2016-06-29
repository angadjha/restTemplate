package com.example.service;

import com.example.RestTemplateConfig;
import com.example.model.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yongjunjung on 2016. 6. 29..
 */

@Service
public class RestTestService {

    public static String LOCAL_URL = "http://localhost:8080/";

    @Autowired
    RestTemplateConfig restTemplateConfig;

    public ResultDTO restTemplateTimeout() {

        String url = LOCAL_URL + "thread/sleep";

        RestTemplate restTemplate = restTemplateConfig.restTemplate();

        ResponseEntity<ResultDTO> responseEntity = restTemplate.postForEntity(url, HttpEntity.EMPTY, ResultDTO.class);
        ResultDTO resultDTO = responseEntity.getBody();


        return resultDTO;
    }

    public ResultDTO defaultRestTemplate() {

        String url = LOCAL_URL + "thread/sleep";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ResultDTO> responseEntity = restTemplate.postForEntity(url, HttpEntity.EMPTY, ResultDTO.class);
        ResultDTO resultDTO = responseEntity.getBody();


        return resultDTO;
    }

}
