package com.portfolio.honeybee.domain.post;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("aws")
public class AwsKey {
    private String accessKey;
    private String bucket;
    private String secretKey;
}
