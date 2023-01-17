package com.dyh.springDemo.service.impl;

import org.springframework.stereotype.Service;

/**
 * description:两个相同的类创建bean失败，因为有相同bean name为AService，
 * 所以抛出BeanDefinitionStoreException异常（bean定义存储异常），提示bean定义冲突，已有同名bean名称'AService'
 * author: dyh
 * date: 2023/1/13 17:39
 */
@Service
public class AService {
}
