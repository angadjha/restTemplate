package com.example.web.api;

import com.example.model.ResultDTO;
import com.example.service.RestTestService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yongjunjung on 2016. 5. 16..
 */

@RestController
public class TestController {

    @Autowired
    RestTestService restTestService;

    @RequestMapping(value = "/thread/sleep")
    public ResultDTO threadSleepTest() {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("테스트");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopWatch.stop();
        System.out.println("stopWatch = " + stopWatch.prettyPrint());


        return new ResultDTO("0000","테스트");
    }

    @RequestMapping(value = "/test/settimeout")
    public ResultDTO setTimeoutTest() {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("시작");

        ResultDTO resultDTO = resultDTO = restTestService.restTemplateTimeout();

        stopWatch.stop();
        System.out.println("stopWatch = " + stopWatch.prettyPrint());

        return resultDTO;
    }

    @RequestMapping(value = "/test/default")
    public ResultDTO defaultTest() {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("unset timeout");

        ResultDTO resultDTO = resultDTO = restTestService.defaultRestTemplate();

        stopWatch.stop();
        System.out.println("stopWatch = " + stopWatch.prettyPrint());

        return resultDTO;
    }

}
