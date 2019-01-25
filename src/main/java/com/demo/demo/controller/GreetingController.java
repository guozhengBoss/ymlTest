package com.demo.demo.controller;

import com.demo.demo.dto.GuozhengYml;
import com.demo.demo.dto.JacksonDateTest;
import com.demo.demo.dto.MyDto;
import com.demo.demo.test.MyTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@EnableConfigurationProperties(GuozhengYml.class)
public class GreetingController {

@Autowired
    MyTest test;
@Autowired
    GuozhengYml guozhengYml;
@Autowired
    MyDto myDto;
//what?
//+++++++++--------------------
    //-----------------------
    /////////////
    @RequestMapping(value="/date", method = RequestMethod.GET)
    public JacksonDateTest dateFormatTest(){
        JacksonDateTest dateFormatTest = new JacksonDateTest();
        dateFormatTest.setName("100");
        dateFormatTest.setDate(new Date());
        return dateFormatTest;
    }
    @RequestMapping(value="/string", method = RequestMethod.GET)
    public void stringDateFormatTest(JacksonDateTest dateFormatTest){
        System.out.println(dateFormatTest.getName());
        System.out.println(dateFormatTest.getDate());
String a ="{ \"name\" : \"100\",\n  \"date\" : \"2019-01-21 11:58:55\"\n}";
    }

    @RequestMapping("/qwe")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        test.testAsyncMethod();
        System.out.println("guozhengYml:"+guozhengYml.getAge()+"::"+guozhengYml.getName());
        return "guozhengYml:"+guozhengYml.getAge()+"::"+guozhengYml.getName();
    }
    @RequestMapping("/bb")
    public String greeting1(@RequestParam(value="name", defaultValue="World") String name) {
        myDto.testAsyncMethod();
        myDto.testAsyncMethod();
        myDto.testAsyncMethod();
        myDto.testAsyncMethod();

        return "aaawwww";
    }
}
