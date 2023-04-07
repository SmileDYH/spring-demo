package com.dyh.springDemo.controller;

import com.dyh.springDemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/test")
    public void test() {
        System.out.println("/demo/test");
        demoService.test();
    }

}
