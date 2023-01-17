package com.dyh.springDemo.controller;

import com.dyh.springDemo.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 测试注入两个相同的类，使用@Service注解
 * author: dyh
 * date: 2023/1/17 11:21
 */
@RestController
@RequestMapping("/demo/service")
public class ServiceDemoController {

    @Autowired
    @Qualifier("aService")
    private AService a;

    /**
     * 默认byType，@Qualifier byName；两个相同的类创建bean失败，详见实现类AService
     * 因为默认byName失效所以属性名称可以随便定义，这里定义为了a
     */
    @GetMapping("/test")
    public void test() {
        a.test();
    }
}
