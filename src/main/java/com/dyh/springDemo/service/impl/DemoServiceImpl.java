package com.dyh.springDemo.service.impl;

import com.dyh.springDemo.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * description: demo service
 * author: dyh
 * date: 2022/4/9 16:39
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public void test(){
        System.out.println("test()");
    }
}
