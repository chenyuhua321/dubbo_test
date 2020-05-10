package com.lagou.webconsumer.controller.bean;

import com.lagou.service.HelloService;
import com.lagou.service.WangService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author Chenyuhua
 * @date 2020/5/10 12:24
 */
@Component
public class HelloConsumerService {
    @Reference
    private HelloService helloService;
    @Reference
    private WangService wangService;

    public String syaHello(String name){
        return helloService.sayHello(name, 1000);
    }

    public String sayWang(String name){
        return wangService.sayWang(name, 1000);
    }
}
