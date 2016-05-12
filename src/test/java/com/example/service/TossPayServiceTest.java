package com.example.service;

import com.example.RestTemplateApplication;
import com.example.model.TossRequest;
import com.example.model.TossResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yongjunjung on 2016. 5. 12..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestTemplateApplication.class)
public class TossPayServiceTest {

    public static String PAY_TOKEN = "test_token1234567890a";
    public static String PAY_OK = "0";

    @Autowired
    TossPayService payService;

    TossRequest request;

    @Before
    public void init() {
        request = new TossRequest("토스테스트", 1000);
    }

    @Test
    public void postForEntityTossPayment() throws Exception {

        //1.Given 2.When
        TossResponse tossResponse = payService.postForEntityTossPayment(request);

        //3.Then
        Assert.assertEquals(tossResponse.getCode(), PAY_OK);
        Assert.assertNull(tossResponse.getCheckoutPage());
        Assert.assertEquals(tossResponse.getPayToken(), PAY_TOKEN);
    }

    @Test
    public void postForObjectTossPayment() throws Exception {

        //1.Given 2.When
        TossResponse tossResponse = payService.postForObjectTossPayment(request);

        //3.Then
        Assert.assertEquals(tossResponse.getCode(), PAY_OK);
        Assert.assertNull(tossResponse.getCheckoutPage());
        Assert.assertEquals(tossResponse.getPayToken(), PAY_TOKEN);
    }

    @Test
    public void exchangeTossPayment() throws Exception {

        //1.Given 2.When
        TossResponse tossResponse = payService.exchangeTossPayment(request);

        //3.Then
        Assert.assertEquals(tossResponse.getCode(), PAY_OK);
        Assert.assertNull(tossResponse.getCheckoutPage());
        Assert.assertEquals(tossResponse.getPayToken(), PAY_TOKEN);
    }
    
    @Test
    public void tosspaySample() throws Exception {
        payService.tosspaySample();
    }


}