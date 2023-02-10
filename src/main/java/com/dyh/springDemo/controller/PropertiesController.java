package com.dyh.springDemo.controller;

import com.dyh.springDemo.common.config.PropertySourceAndConfigurationPropertiesConfig;
import com.dyh.springDemo.common.config.PropertySourceAndValueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 配置/属性 Controller
 * author: dyh
 * date: 2023/2/10 17:21
 */
@RestController
@RequestMapping("/demo/properties")
@Slf4j
public class PropertiesController {

    @Value("${name}")
    private String name;

    @Value("${spring.application.name}")
    private String aplicationName;

    @Value("${spring.application.namea:bbb}")
    private String aplicationNamea;

    @GetMapping("/testValue")
    public void testValue() {
        //测试属性
        System.out.println("name--->" + name);
        System.out.println("aplicationName--->" + aplicationName);
        System.out.println("aplicationNamea--->" + aplicationNamea);
    }


    @Autowired
    private PropertySourceAndConfigurationPropertiesConfig configurationPropertiesConfig;

    @Autowired
    private PropertySourceAndValueConfig valueConfig;

    @GetMapping("/testPropertySource")
    public void testPropertySource() {
        //测试属性
        System.out.println("name--->" + configurationPropertiesConfig.getName());
        System.out.println("age--->" + valueConfig.getAge());
        AnnotationConfigApplicationContext a =new AnnotationConfigApplicationContext(PayController.class,ParentChildContainerDemo.class);
    }
}
