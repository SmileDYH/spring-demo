package com.dyh.springDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Map;

/**
 * description: 父子容器
 * author: dyh
 * date: 2022/11/10 11:07
 */
@SpringBootTest
public class ParentChildContainerTest {

    // BeanFactory  spring容器的顶层接口，支持容器嵌套结构查找；会从沿着当前容器向上查找，直到找到满足条件的bean为止。
    // ListableBeanFactory  这个接口中的方法不支持容器嵌套结构查找。
    // DefaultListableBeanFactory  继承了BeanFactory 和 ListableBeanFactory
    // BeanFactoryUtils   这个类中提供了很多静态方法，有很多支持层次查找的方法；名称中包含有Ancestors的都是支持层次查找的。
    @Test
    void test() {
        //创建父容器parentFactory
        DefaultListableBeanFactory parentFactory = new DefaultListableBeanFactory();
        //向父容器parentFactory注册一个bean[userName->"路人甲Java"]
        parentFactory.registerBeanDefinition("userName",
                BeanDefinitionBuilder.
                        genericBeanDefinition(String.class).
                        addConstructorArgValue("路人甲Java").
                        getBeanDefinition());

        //创建一个子容器childFactory
        DefaultListableBeanFactory childFactory = new DefaultListableBeanFactory();
        //调用setParentBeanFactory指定父容器
        childFactory.setParentBeanFactory(parentFactory);
        //向子容器parentFactory注册一个bean[address->"上海"]
        childFactory.registerBeanDefinition("address",
                BeanDefinitionBuilder.
                        genericBeanDefinition(String.class).
                        addConstructorArgValue("上海").
                        getBeanDefinition());

        //调用子容器的getBean方法，获取名称为userName的bean;
        //userName这个bean是在父容器中定义的，而getBean方法是BeanFactory接口中定义的，支持容器层次查找，所以getBean是可以找到userName这个bean的
        System.out.println("获取bean【userName】：" + childFactory.getBean("userName"));//@1
        //调用子容器的getBeanNamesForType方法，获取所有String类型的bean名称;
        //而getBeanNamesForType方法是ListableBeanFactory接口中定义的，这个接口中方法不支持层次查找，只会在当前容器中查找，所以这个方法只会返回子容器的address
        System.out.println(Arrays.asList(childFactory.getBeanNamesForType(String.class))); //@2
//        System.out.println(parentFactory.getBean("address")); //@3 No bean named 'address' available (没有这个bean)
        System.out.println(parentFactory.getBean("userName")); //@4

        //层次查找所有符合类型的  bean名称
        String[] beanNamesForTypeIncludingAncestors =
                BeanFactoryUtils.beanNamesForTypeIncludingAncestors(childFactory, String.class);
        System.out.println(Arrays.asList(beanNamesForTypeIncludingAncestors));
        //层次查找所有符合类型的  bean
        Map<String, String> beansOfTypeIncludingAncestors =
                BeanFactoryUtils.beansOfTypeIncludingAncestors(childFactory, String.class);
        System.out.println(Arrays.asList(beansOfTypeIncludingAncestors));
    }

}
