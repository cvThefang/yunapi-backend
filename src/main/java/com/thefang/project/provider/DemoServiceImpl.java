package com.thefang.project.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @Description
 * @Author Thefang
 * @Create 2025/7/21
 */
@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        System.out.println("sayHello" + name + ", request from consumer" + RpcContext.getServiceContext().getRemoteAddressString());
        return "hello" + name;
    }

    @Override
    public String sayGoodbye(String name) {
        return "goodbye" + name;
    }
}
