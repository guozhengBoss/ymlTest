package com.demo.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * @author ：古征
 * @date ：Created in 2019/1/21 8:49
 * @description：test
 * @modified By：
 * @version: 1.0
 */

//aaa

public class JacksonDateTest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
