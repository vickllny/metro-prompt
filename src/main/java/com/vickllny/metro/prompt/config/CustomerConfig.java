package com.vickllny.metro.prompt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "customer-config")
public class CustomerConfig {
    private String trainFilePrefix;
}
