package com.wwj.springboot.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * bean注入方式(四种)setter注入
 *
 * @author weiwenjun
 * @since 2019/5/21
 */
@Component
public class BeanRegisterSetter {

    private DependencyA dependencyA;
    private DependencyB dependencyB;
    private DependencyC dependencyC;

    public DependencyA getDependencyA() {
        return dependencyA;
    }

    @Autowired
    public void setDependencyA(DependencyA dependencyA) {
        this.dependencyA = dependencyA;
    }

    public DependencyB getDependencyB() {
        return dependencyB;
    }

    @Autowired
    public void setDependencyB(DependencyB dependencyB) {
        this.dependencyB = dependencyB;
    }

    public DependencyC getDependencyC() {
        return dependencyC;
    }

    @Autowired
    public void setDependencyC(DependencyC dependencyC) {
        this.dependencyC = dependencyC;
    }

    public void run() {
        System.out.println("BeanRegisterSetter:" + dependencyA.getName());
    }
}
