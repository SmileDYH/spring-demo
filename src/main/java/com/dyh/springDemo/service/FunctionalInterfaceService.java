package com.dyh.springDemo.service;

/**
 * description: 函数接口service
 * author: dyh
 * date: 2023/1/6 10:42
 */
//注解不写不会报错，但这属于约定，@FunctionalInterface注解的含义是只能有一个非default方法
@FunctionalInterface
public interface FunctionalInterfaceService {

    //函数方法，也叫钩子方法
    void test();
}
