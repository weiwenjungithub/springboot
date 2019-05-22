package com.wwj.springboot.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * bean注入方式(四种)
 *
 * @author weiwenjun
 * @since 2019/5/21
 */
@Component
public class BeanRegisterConstructor {

    private DependencyA dependencyA;
    private DependencyB dependencyB;
    private DependencyC dependencyC;

    @Autowired
    public BeanRegisterConstructor(DependencyA dependencyA, DependencyB dependencyB, DependencyC dependencyC) {
        this.dependencyA = dependencyA;
        this.dependencyB = dependencyB;
        this.dependencyC = dependencyC;
    }

    public void run() {
        System.out.println("BeanRegisterConstructor:" + dependencyA.getName());
    }
}
