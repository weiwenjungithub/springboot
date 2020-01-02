package com.wwj.springboot.initbeanafterexec;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author weiwenjun
 * @since 2019/7/22
 * bean初始化完成后执行的三种方法
 */
@Component
public class InitBeanAfterExec implements InitializingBean {


    /**
     * 实现InitializingBean接口
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行 init InitializingBean afterPropertiesSet");
    }

    /**
     * 使用postconstrtct注解
     */
    @PostConstruct
    public void post() {
        System.out.println("执行 PostConstruct");
    }

    /**
     * 在xml配置文件中配置init-method方法
     **/
    public void xml() {
        System.out.println("执行init-method方法 ");
    }

}
