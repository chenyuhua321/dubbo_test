package com.lagou.service.impl;

import com.lagou.service.HelloService;
import org.apache.commons.lang3.RandomUtils;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name, int timeToWait) {
        try {
            Thread.sleep(RandomUtils.nextInt(0,100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello:"+name;
    }

    @Override
    public String sayWang(String name, int timeToWait) {
        try {
            Thread.sleep(RandomUtils.nextInt(0,100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "wang:"+name;
    }

    @Override
    public String sayMiao(String name, int timeToWait) {
        try {
            Thread.sleep(RandomUtils.nextInt(0,100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "miao:"+name;
    }
}
