package com.dyh.springDemo.service.impl;

import com.dyh.springDemo.service.FunctionalInterfaceService;
import org.springframework.stereotype.Service;

/**
 * description: 函数式接口实现类
 * author: dyh
 * date: 2023/1/6 10:42
 */
@Service
public class FunctionalInterfaceAServiceImpl implements FunctionalInterfaceService {

    @Override
    public void test(){
        System.out.println("实现类A");
    }
}
