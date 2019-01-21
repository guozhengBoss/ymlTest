package com.demo.demo.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ：古征
 * @date ：Created in 2019/1/11 9:36
 * @description：YmlTest
 * @modified By：
 * @version: 1.0
 */

@Component
@Configuration
@ConfigurationProperties(prefix = "guozheng")
public class GuozhengYml {
//    @Value("${guozheng12.name}")
    private String name;
//    @Value("${guozheng12.age}")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
