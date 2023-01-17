package com.dyh.springDemo.service.impl;

import com.dyh.springDemo.service.Pay;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 支付宝支付
 * /@Component注入的bean name为ALipayImpl
 * 可以通过@Primary注解来标识默认的bean
 */
@Component
//@Primary
public class ALipayImpl implements Pay {
    @Override
    public void doPay() {
        System.out.println("支付宝支付");
    }
}