package com.wwj.springboot.config;

import com.wwj.springboot.core.TestBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author weiwenjun
 * @since 2019/2/2
 */
@Component
public class MyBean implements BeanDefinitionRegistryPostProcessor {

    private static final String MY_BEAN_NAME = "MY_BEAN_NAME";

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        TestBean testBean = new TestBean();
        testBean.setName(MY_BEAN_NAME);
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(TestBean.class);
        registry.registerBeanDefinition(MY_BEAN_NAME, beanDefinitionBuilder.getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory.getBeanDefinitionCount());
    }
}
