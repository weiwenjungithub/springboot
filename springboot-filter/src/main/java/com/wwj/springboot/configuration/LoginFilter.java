package com.wwj.springboot.configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author weiwenjun
 * @since 2019/2/2
 * 登录过滤器
 */
public class LoginFilter implements Filter {

    private static final String TOKEN = "123456";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("登录过滤器被调用");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String token = httpServletRequest.getParameter("token");
        if (token == null) {
            httpServletResponse.getWriter().write("Please login");
            return;
        } else if (!TOKEN.equals(token)) {
            httpServletResponse.getWriter().write("token error");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
