package com.demo.demo.test;

/**
 * @author ：古征
 * @date ：Created in 2019/1/9 8:38
 * @description：s
 * @modified By：
 * @version: 1.0
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class MyTest {

    @Async
    public  void testAsyncMethod(){
        try {
            //让程序暂停100秒，相当于执行一个很耗时的任务
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
