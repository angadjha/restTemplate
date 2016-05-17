package com.example.web.api;

import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yongjunjung on 2016. 5. 16..
 */

@RestController
public class TestController {



    @RequestMapping(value = "/thread/sleep")
    public void threadSleepTest() {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("zzzz");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopWatch.stop();
        System.out.println("stopWatch = " + stopWatch.prettyPrint());
    }

}
