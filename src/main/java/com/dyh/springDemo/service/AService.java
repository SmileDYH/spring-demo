package com.dyh.springDemo.service;

import org.springframework.stereotype.Service;

/**
 * description: 如果没有指定Spring创建的bean的名称
 * (1) 默认名为类名，但首字母小写，如：UserService类，创建的bean的name为userService
 * (2) 如果类名前两个或以上字母都为大写，那么bean的名字就是类名，如：TUserService类，默认创建的bean的name为TUserService
 * author: dyh
 * date: 2023/1/13 17:39
 */
@Service("aService")
public class AService {

    public void test(){
        System.out.println("这是aService...");
    }
}
