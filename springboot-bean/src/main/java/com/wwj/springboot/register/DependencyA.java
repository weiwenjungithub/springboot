package com.wwj.springboot.register;

import org.springframework.stereotype.Component;

/**
 * @author weiwenjun
 * @since 2019/5/21
 */
@Component
public class DependencyA {

    public String getName() {
        return "my name is A";
    }
}
