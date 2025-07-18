package com.thefang.yunapiclientsdk;

import com.thefang.yunapiclientsdk.client.YunApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Thefang
 * @Create 2025/7/17
 */
@Configuration
@ConfigurationProperties("yunapi.client")
@Data
@ComponentScan
public class YunApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public YunApiClient yunApiClient() {
        return new YunApiClient(accessKey, secretKey);
    }
}
