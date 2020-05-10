# dubbo_test

#### 介绍
dubbo test

1. 作业一：
   请求地址:http://localhost:8888/hello?name=1

   通过实现拦截器获取httpServletRequest获取请求端IP地址，存到RPContext中的Attachment中并借助IPUtil缓存IP避免RPC每次将Attachment清空。

   使得IP在多服务间传输类似traceId

   作业二：

   

![image-20200510204840794](https://gitee.com/chenyuhua321/dubbo_test/raw/master/img/image-20200510204840794.png)