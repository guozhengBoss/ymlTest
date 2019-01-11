package com.demo.demo.controller;

import com.demo.demo.dto.GuozhengYml;
import com.demo.demo.test.MyTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@EnableConfigurationProperties(GuozhengYml.class)
public class GreetingController {

@Autowired
    MyTest test;
@Autowired
    GuozhengYml guozhengYml;
    @RequestMapping
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        test.testAsyncMethod();
        System.out.println("guozhengYml:"+guozhengYml.getAge()+"::"+guozhengYml.getName());
        return "guozhengYml:"+guozhengYml.getAge()+"::"+guozhengYml.getName();
    }
    @RequestMapping("/bb")
    public String greeting1(@RequestParam(value="name", defaultValue="World") String name) {
        return "aaawwww";
    }
}
