package com.dyh.springDemo.service.impl;

import com.dyh.springDemo.service.FunctionalInterfaceService;
import org.springframework.stereotype.Service;

/**
 * description: 函数式接口实现类
 * author: dyh
 * date: 2023/1/6 10:42
 */
//Injection of resource dependencies failed; nested exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException:
// No qualifying bean of type 'com.dyh.springDemo.service.FunctionalInterfaceService' available: expected single matching bean but found 2:
// functionalInterfaceAServiceImpl,functionalInterfaceBServiceImpl
//两个实现类注入失败
//@Service
public class FunctionalInterfaceBServiceImpl implements FunctionalInterfaceService {

    @Override
    public void test(){
        System.out.println("实现类B");
    }
}
