package com.wwj.springboot.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContextAware的最本质的应用就是：对当前bean传入对应的Spring上下文。
 *
 * 1.保存Spring上下文
 * 例如上文中的ApplicationContextHelper，专门创建一个Bean，用于维护Spring ApplicationContext。
 * 并且可以将ApplicationContextHelper通过@Resource的形式注入到其他组件中。这样相当于为所有的Bean提供可一个操作Spring上下文的工具类
 *
 * 2.监听上下文启动，并完成相关操作
 * 通过在实例化到时候，通过上下文调用setApplicationContext方法，然后完成一些自定义的操作。例如加载某些特殊的实例，对bean进行操作等。
 * @author weiwenjun
 */
@Component
public class CommonConfig implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }
}
