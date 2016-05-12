package com.example.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by yongjunjung on 2016. 5. 12..
 */
public class TossRequest {

    public static final String API_KEY = "sk_test_apikey1234567890a";

    private String apiKey;
    private String orderNo;
    private Integer amount;
    private String productDesc;

    private Timestamp expiredTime;
    private String orderCheckCallback;
    private String resultCallback;

    public TossRequest(String orderNo, Integer amount) {
        this.orderNo = orderNo;
        this.amount = amount;
        this.productDesc = "테스트결제";
        this.expiredTime = Timestamp.valueOf(LocalDateTime.now().plusHours(2));
        this.apiKey = API_KEY;
        this.orderCheckCallback = "/toss/reqeust";
        this.resultCallback = "http://naver.com";
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Timestamp getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Timestamp expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getOrderCheckCallback() {
        return orderCheckCallback;
    }

    public void setOrderCheckCallback(String orderCheckCallback) {
        this.orderCheckCallback = orderCheckCallback;
    }

    public String getResultCallback() {
        return resultCallback;
    }

    public void setResultCallback(String resultCallback) {
        this.resultCallback = resultCallback;
    }

    @Override
    public String toString() {
        return "TossRequest{" +
                "orderNo='" + orderNo + '\'' +
                ", amount='" + amount + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", expiredTime='" + expiredTime + '\'' +
                ", orderCheckCallback='" + orderCheckCallback + '\'' +
                ", resultCallback='" + resultCallback + '\'' +
                '}';
    }
}
