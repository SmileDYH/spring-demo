package com.dyh.springDemo.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * description:测试 @PropertySource 和 @ConfigurationProperties组合
 * author: dyh
 * date: 2023/1/29 11:53
 */
@Component
@Data
@PropertySource(value = "application.properties")
@ConfigurationProperties("demo")
public class PropertySourceAndConfigurationPropertiesConfig {

    private String name;

    private Integer age;
}
