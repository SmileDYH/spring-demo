package com.dyh.springDemo.controller;

import com.dyh.springDemo.service.FunctionalInterfaceService;
import com.dyh.springDemo.service.impl.FunctionalInterfaceAServiceImpl;
import com.dyh.springDemo.service.impl.FunctionalInterfaceBServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description: 函数式接口Controller
 * author: dyh
 * date: 2023/1/17 11:25
 */
@RestController
@RequestMapping("/demo/functiona")
public class FunctionalInterfaceController {

    @Resource
    private FunctionalInterfaceService functionalInterfaceService;

    @GetMapping("/test")
    public void test() {
        //两个以上实现类启动会报错，bean定义冲突，已有相同的bean name
        functionalInterfaceService.test();
        System.out.println("----调用注入的bean----");

        FunctionalInterfaceService functionalInterfaceService = new FunctionalInterfaceAServiceImpl();
        functionalInterfaceService.test();
        System.out.println("-------调用接口A--------");

        functionalInterfaceService = new FunctionalInterfaceBServiceImpl();
        functionalInterfaceService.test();
        System.out.println("-------调用接口B--------");

        //匿名内部类
        FunctionalInterfaceService anonymousClasses = new FunctionalInterfaceService() {
            @Override
            public void test() {
//                test(); //调用的是自己，递归了
                System.out.println("匿名内部类，重写test()方法...");
            }
        };
        anonymousClasses.test();

        //lambda表达式
        // 一个入参可不写括号 a -> System.out.println("lambda表达式,重写test()方法...");
        // 一行方法体可不写中括号 () -> System.out.println("lambda表达式,重写test()方法...");
        FunctionalInterfaceService lambda = () -> {
            System.out.println("lambda表达式,重写test()方法...");
        };
        //多态调用
        lambda.test();
    }
}
