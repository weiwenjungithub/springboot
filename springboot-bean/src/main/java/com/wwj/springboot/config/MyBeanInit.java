package com.wwj.springboot.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author weiwenjun
 * @since 2019/5/21
 */

@Component
public class MyBeanInit implements BeanPostProcessor, InitializingBean, BeanDefinitionRegistryPostProcessor {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean:afterPropertiesSet........................");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor:postProcessBeforeInitialization:" + beanName + "........................");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor:postProcessAfterInitialization" + beanName + "........................");
        return bean;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor:postProcessBeanDefinitionRegistry........................");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor:postProcessBeanFactory........................");
    }
}
