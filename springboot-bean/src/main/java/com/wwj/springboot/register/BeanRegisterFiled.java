package com.wwj.springboot.register;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author weiwenjun
 * @since 2019/5/21
 */
public class BeanRegisterFiled {

    @Autowired
    private DependencyA dependencyA;
    @Autowired
    private DependencyB dependencyB;
    @Autowired
    private DependencyC dependencyC;

    public void run() {
        System.out.println("BeanRegisterFiled:" + dependencyA.getName());
    }
}
