package com.dyh.springDemo.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * description:测试 @PropertySource 和 @Value组合
 * author: dyh
 * date: 2023/1/29 11:53
 */
@Component
@Data
@PropertySource(value = "application.properties")
public class PropertySourceAndValueConfig {

    @Value("${demo.name}")
    private String name;

    @Value("${demo.age}")
    private Integer age;
}
