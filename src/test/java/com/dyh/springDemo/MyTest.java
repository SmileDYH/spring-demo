package com.dyh.springDemo;

import com.dyh.springDemo.parent.ParentTest;
import org.junit.jupiter.api.Test;

/**
 * 测试ParentTest
 */
public class MyTest extends ParentTest {
    @Test
    public void test1(){
        System.out.println("hi test");
    }
}