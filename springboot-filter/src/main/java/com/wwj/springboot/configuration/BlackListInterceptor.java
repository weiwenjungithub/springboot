package com.wwj.springboot.configuration;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author weiwenjun
 * @since 2019/2/2
 * 黑名单拦截器
 */
public class BlackListInterceptor implements HandlerInterceptor {

    /**
     * 黑名单列表
     */
    private static final List<String> BLACK_LIST = Arrays.asList("zhangsan", "wangwu");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("黑名单拦截器被调用");
        for (String name : BLACK_LIST) {
            if (name.equals(request.getParameter("name"))) {
                try {
                    System.out.println(name + "被拦截");
                    response.getWriter().write("you have been blacklisted:" + name);
                    return false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return true;
    }
}
