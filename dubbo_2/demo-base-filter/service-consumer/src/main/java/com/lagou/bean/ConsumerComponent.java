package com.lagou.bean;

import com.lagou.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class ConsumerComponent {

    @Reference
    private HelloService helloService;

    public String sayHello(String name, int timeToWait) {
        try {
            return helloService.sayHello(name, timeToWait);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return "";
        }
    }

    public String sayWang(String name, int timeToWait) {
        try {
            return helloService.sayWang(name, timeToWait);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return "";
        }
    }

    public String sayMiao(String name, int timeToWait) {
        try {
            return helloService.sayMiao(name, timeToWait);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return "";
        }
    }

}
