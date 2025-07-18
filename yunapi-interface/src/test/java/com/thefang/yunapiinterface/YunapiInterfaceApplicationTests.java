package com.thefang.yunapiinterface;

import com.thefang.yunapiclientsdk.client.YunApiClient;
import com.thefang.yunapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class YunapiInterfaceApplicationTests {


    @Resource
    private YunApiClient yunApiClient;

    @Test
    void contextLoads() {
        String result1 = yunApiClient.getNameByGet("珍珍大侦探");
        User user = new User();
        user.setUserName("珍珍大厨");
        String result2 = yunApiClient.getUserNameByPost(user);
        System.out.println(result1);
        System.out.println(result2);
    }

}
