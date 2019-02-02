package com.wwj.springboot.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author weiwenjun
 * @since 2019/2/2
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //只拦截请求路径为user的接口
        registry.addInterceptor(new BlackListInterceptor()).addPathPatterns("/user/**");
        System.out.println("addInterceptors");
    }

    /**
     * 添加过滤器
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public FilterRegistrationBean filterRegister() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new LoginFilter());
        frBean.addUrlPatterns("/user/**");
        System.out.println("filter");
        return frBean;
    }

    /**
     * 添加监听器
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public ServletListenerRegistrationBean listenerRegister() {
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new OnlineListener());
        System.out.println("listener");
        return srb;
    }
}
