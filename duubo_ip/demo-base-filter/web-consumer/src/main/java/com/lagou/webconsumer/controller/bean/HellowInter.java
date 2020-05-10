package com.lagou.webconsumer.controller.bean;

import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Chenyuhua
 * @date 2020/5/10 15:23
 */
@Component
public class HellowInter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RpcContext.getContext().setAttachment("remoteAddr",request.getRemoteAddr());
        return true;
    }
}
