package com.dyh.springDemo.service.impl;

import com.dyh.springDemo.service.Pay;
import org.springframework.stereotype.Component;

/**
 * 微信支付
 * /@Component注入的bean name为weChatImpl
 * 可以通过@Component的value属性来指定bean name
 */
@Component
//@Component("weChat")
public class WeChatImpl implements Pay {
    @Override
    public void doPay() {
        System.out.println("微信支付");
    }
}