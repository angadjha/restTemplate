package com.example.web.api;

import com.example.model.Request;
import com.example.model.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yongjunjung on 2016. 5. 10..
 */

@RestController
public class RestTemplateController {


    @RequestMapping(value = "/request",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response exampleRestTemplate(@RequestBody Request request) {

        String grade = getGrade(request.getScore());

        Response response = new Response();
        response.setName(request.getName());
        response.setId(request.getId());
        response.setGrade(grade);

        return response;
    }

    public String getGrade(int score) {

        String grade = "F";

        if (score > 50) {
            grade = "A";
        }

        return grade;
    }


}
