package com.yuan.javabasic.service.impl;

import com.yuan.javabasic.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ykj
 * @date 2023/1/10/21:02
 * @apiNote
 */
public class TestServiceImpl implements TestService {
    
    private TestService testService;
    
    
    /**
     * setter注入
     * 应该被用于可选依赖项，当没有提供依赖时，类应该依然能够正常工作，当对象被实例化后，依赖项可以在任何时候都可以被更改
     * @param testService
     */
    @Autowired
    public void setTestService(TestService testService){
        this.testService = testService;
    }
    
    /**
     * 构造器注入
     * 有利于强制依赖。通过在构造函数中提供依赖，可以确保依赖对象在被构造时已准备好被使用，在构造函数 的赋值可以是final，这样的话以来的属性就不能被更改
     * @param testService
     */
    @Autowired
    public TestServiceImpl(TestService testService){
        this.testService = testService;
    }
    
}
