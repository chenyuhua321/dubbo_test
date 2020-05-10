package com.lagou.webconsumer.controller;

import com.lagou.webconsumer.controller.bean.HelloConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Chenyuhua
 * @date 2020/5/10 11:34
 */
@RestController
public class HelloController {
    @Resource
    private HelloConsumerService helloConsumerService;

    @GetMapping("/hello")
    public String syaHello(@RequestParam("name") String name, HttpServletRequest request) {
        String s = helloConsumerService.syaHello(name);
        System.out.println("response:" + s);

        String wangRep = helloConsumerService.sayWang(name);
        System.out.println("wang response:" + wangRep);

        String remoteAddressString = request.getRemoteAddr();
        System.out.println("client request:" + remoteAddressString);
        return s + wangRep;
    }
}
