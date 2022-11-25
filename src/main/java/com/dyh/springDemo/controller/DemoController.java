package com.dyh.springDemo.controller;

import com.dyh.springDemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: demo controller
 * author: dyh
 * date: 2022/4/9 16:38
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Value("${name}")
    private String name;

    @Value("${spring.application.name}")
    private String aplicationName;

    @GetMapping("/test")
    public void test(){
        System.out.println("/demo/test");
        demoService.test();

        System.out.println("name--->" + name);
        System.out.println("aplicationName--->" + aplicationName);
    }
}
