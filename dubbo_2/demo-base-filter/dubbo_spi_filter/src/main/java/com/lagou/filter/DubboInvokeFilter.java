package com.lagou.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@Activate(group = {CommonConstants.CONSUMER})
public class DubboInvokeFilter implements Filter{

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        long startTime = System.currentTimeMillis();
        String methodName = invocation.getMethodName();
        try {
            // 执行方法
            return invoker.invoke(invocation);
        } finally {
            Map<String, Map<Date, Long>> mothodTime = ConsumerTime.getInstance().getMothodTime();
            long cost =  System.currentTimeMillis() - startTime;
            System.out.println("invoke time:" + cost + "毫秒");
            Map<Date, Long> dateLongMap = mothodTime.get(methodName);
            if(Objects.isNull(dateLongMap)){
                dateLongMap = new ConcurrentHashMap<>();
            }
            dateLongMap.put(new Date(),cost);
            mothodTime.put(methodName,dateLongMap);
        }
    }
}
