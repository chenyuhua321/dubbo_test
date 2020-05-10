package com.lagou.service.impl;

import com.lagou.service.HelloService;
import com.lagou.service.WangService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class WangServiceImpl implements WangService {

    @Override
    public String sayWang(String name, int timeToWait) {
        return "wang:"+name;
    }
}
