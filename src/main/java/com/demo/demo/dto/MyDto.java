package com.demo.demo.dto;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author ：古征
 * @date ：Created in 2019/1/10 13:31
 * @description：dto
 * @modified By：
 * @version: 1.0
 */
//local 1+
    //local 3+
@Component
public class MyDto {
@Cacheable(value = "heap-cache")
    public  String testAsyncMethod(){

        System.out.println("using method");
        return "ok";
    }
}
