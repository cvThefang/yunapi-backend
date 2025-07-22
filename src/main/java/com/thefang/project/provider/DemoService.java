package com.thefang.project.provider;

import java.util.concurrent.CompletableFuture;

/**
 * @Description
 * @Author Thefang
 * @Create 2025/7/21
 */
public interface DemoService {

    String sayHello(String name);

    String sayGoodbye(String name);

    default CompletableFuture<String> sayHelloAsync(String name) {
        return CompletableFuture.completedFuture(sayHello(name));
    }
}
