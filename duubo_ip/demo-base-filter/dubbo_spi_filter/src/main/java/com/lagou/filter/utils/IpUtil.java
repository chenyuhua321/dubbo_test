package com.lagou.filter.utils;

/**
 * @author Chenyuhua
 * @date 2020/5/10 21:28
 */
public class IpUtil {
    private static final ThreadLocal<String> IpCache
            = new ThreadLocal<String>();

    public static String getIp() {
        return IpCache.get();
    }

    public static void setIp(String ip) {
        IpCache.set(ip);
    }

    public static void clear() {
        IpCache.remove();
    }
}
