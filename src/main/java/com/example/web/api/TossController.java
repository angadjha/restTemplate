package com.example.web.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yongjunjung on 2016. 5. 12..
 */

@RestController
public class TossController {

    @RequestMapping(value = "/toss/reqeust")
    public void tossPayments() {

        System.out.println("성공");


    }


}
