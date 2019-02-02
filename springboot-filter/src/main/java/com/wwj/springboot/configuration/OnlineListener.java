package com.wwj.springboot.configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author weiwenjun
 * @since 2019/2/2
 */
public class OnlineListener implements HttpSessionListener {

    private static int online = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(5);
        online++;
        System.out.println("创建session,当前在线人数:" + online);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        online--;
        System.out.println("销毁session,当前在线人数:" + online);
    }
}
