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

import static org.junit.Assert.*;

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
    public void getForObjectReceipt() throws Exception {

        ReceiptRequest receiptRequest = new ReceiptRequest(SERVICE_ID, SERVICE_TRADE_NO);
        ReceiptResponse response = restGetService.getForObjectReceipt(receiptRequest);

        System.out.println("response = " + response.toString());

        Assert.assertEquals("16961754", response.getApprove_no());
        Assert.assertEquals("하나카드", response.getCard_nm());
        Assert.assertEquals("3000", response.getAmount());
        Assert.assertEquals("00", response.getQuota());
        Assert.assertEquals("NM8L51W6ZL", response.getTrade_no());
    }

}