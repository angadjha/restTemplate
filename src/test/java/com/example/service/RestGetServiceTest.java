package com.example.service;

import com.example.RestTemplateApplication;
import com.example.model.ReceiptRequest;
import com.example.model.ReceiptResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yongjunjung on 2016. 5. 17..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestTemplateApplication.class)
public class RestGetServiceTest {

    @Autowired
    RestGetService restGetService;

    public static String SERVICE_ID = "baropay";
    public static String SERVICE_TRADE_NO = "BEGKR02240";

    @Test
    public void getExchange() throws Exception {

        //1.Given
        ReceiptRequest receiptRequest = new ReceiptRequest(SERVICE_ID, SERVICE_TRADE_NO);

        //2.When
        ReceiptResponse response = restGetService.getExchange(receiptRequest);
        System.out.println("response = " + response.toString());

        //3.Then
        Assert.assertEquals("16961754", response.getApprove_no());
        Assert.assertEquals("하나카드", response.getCard_nm());
        Assert.assertEquals("3000", response.getAmount());
        Assert.assertEquals("00", response.getQuota());
        Assert.assertEquals("NM8L51W6ZL", response.getTrade_no());
    }

    @Test
    public void getForObject() throws Exception {

        //1.Given
        ReceiptRequest receiptRequest = new ReceiptRequest(SERVICE_ID, SERVICE_TRADE_NO);

        //2.When
        ReceiptResponse response = restGetService.getForObject(receiptRequest);
        System.out.println("response = " + response.toString());

        //3.Then
        Assert.assertEquals("16961754", response.getApprove_no());
        Assert.assertEquals("하나카드", response.getCard_nm());
        Assert.assertEquals("3000", response.getAmount());
        Assert.assertEquals("00", response.getQuota());
        Assert.assertEquals("NM8L51W6ZL", response.getTrade_no());
    }

    @Test
    public void getForEntity() throws Exception {

        //1.Given
        ReceiptRequest receiptRequest = new ReceiptRequest(SERVICE_ID, SERVICE_TRADE_NO);

        //2.When
        ReceiptResponse response = restGetService.getForEntity(receiptRequest);
        System.out.println("response = " + response.toString());

        //3.Then
        Assert.assertEquals("16961754", response.getApprove_no());
        Assert.assertEquals("하나카드", response.getCard_nm());
        Assert.assertEquals("3000", response.getAmount());
        Assert.assertEquals("00", response.getQuota());
        Assert.assertEquals("NM8L51W6ZL", response.getTrade_no());
    }

}