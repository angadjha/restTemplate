package com.example.util;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ReflectionUtils;

/**
 * Created by yongjunjung on 2016. 5. 12..
 */
public class QueryParamGenerator {

    public MultiValueMap<String, String> generate(Object obj) {

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();

        ReflectionUtils.doWithFields(obj.getClass(), field -> {
            ReflectionUtils.makeAccessible(field);
            queryParams.add(field.getName(), ReflectionUtils.getField(field, obj).toString());

        });

        return queryParams;
    }

}
