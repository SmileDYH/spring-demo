package com.dyh.springDemo.controller;

import com.dyh.springDemo.service.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 如果byType相同（这里两个实现了Pay），按byName，
 * /@Autowired自动装配默认bean name为 属性名称（例如：ALipayImpl、weChatImpl）
 * 详见 AService类
 */
@RestController
public class PayController {

    @Autowired
    private Pay ALipayImpl;

    @Autowired
    private Pay weChatImpl;

    //通过@Primary注解，来指定优先调用的
//    @Autowired
//    private Pay pay;

    //通过@Qualifier注解，来指定调用的bean name，
    // 不用注解通过属性名称weChat也可以自动装配成功，因为@Autowired找不到byType，会自动找byName
//    @Autowired
//    @Qualifier("weChat")
//    private Pay weChat;

    @GetMapping("/pay")
    public String pay() {
        ALipayImpl.doPay();
        weChatImpl.doPay();
//        pay.doPay();
//        weChat.doPay();
        return "test success";
    }
}