package com.lagou.filter;

import com.lagou.filter.utils.IpUtil;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.*;



@Activate(group = {CommonConstants.CONSUMER, CommonConstants.PROVIDER})
public class DubboInvokeFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        long startTime = System.currentTimeMillis();
        String remoteAddr = RpcContext.getContext().getAttachment("remoteAddr");
        if ( !StringUtils.isEmpty(remoteAddr) ) {
            // *) 从RpcContext里获取remoteAddr并保存
            IpUtil.setIp(remoteAddr);
        } else {
            // *) 交互前重新设置remoteAddr, 避免信息丢失
            RpcContext.getContext().setAttachment("remoteAddr", IpUtil.getIp());
        }

        System.out.println("remoteAddr:"+remoteAddr);
        try {
            // 执行方法
            return invoker.invoke(invocation);
        } finally {
            System.out.println("invoke time:" + (System.currentTimeMillis() - startTime) + "毫秒");
        }

    }
}
