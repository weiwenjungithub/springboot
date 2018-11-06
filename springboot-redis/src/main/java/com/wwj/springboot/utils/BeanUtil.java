package com.wwj.springboot.utils;

import com.wwj.springboot.bean.Book;
import com.wwj.springboot.bean.Ownwer;

import java.lang.reflect.Field;

/**
 * @author weiwenjun
 * @since 2018/10/7
 */
public class BeanUtil<T> {

    public static void main(String[] args) throws Exception {

        BeanUtil<Book> beanUtil = new BeanUtil<>();
        Book book = new Book();
        Ownwer ownwer = new Ownwer();
        ownwer.setTel("123456");
        book.setOwnwer(ownwer);
        Book b = beanUtil.set(book, "ownwer/name", "张三");
        System.out.println(b);

        String book1 = beanUtil.get(book, "ownwer/tel", String.class);
        System.out.println(book1);
    }

    private <T> T set(T t, String s, Object name) throws Exception {
        String[] split = s.split("/");
        Object o = t;
        for (int i = 0; i < split.length; i++) {
            if (split.length - 1 == i) {
                Field declaredField = o.getClass().getDeclaredField(split[i]);
                declaredField.setAccessible(true);
                declaredField.set(o, name);
            } else {
                Field declaredField = t.getClass().getDeclaredField(split[i]);
                declaredField.setAccessible(true);
                o = declaredField.get(o);
            }
        }
        return t;
    }

    private <T> T get(Object t, String s, Class<T> clazz) throws Exception {
        String[] split = s.split("/");
        Object o = t;
        for (int i = 0; i < split.length; i++) {
            Field declaredField = o.getClass().getDeclaredField(split[i]);
            declaredField.setAccessible(true);
            o = declaredField.get(o);
        }
        if (!o.getClass().getTypeName().equals(clazz.getTypeName())) {
            throw new ClassCastException("传入的类型[" + clazz.getTypeName() + "]与获得的[" + o.getClass().getTypeName() + "]不符合");
        }
        return (T) o;
    }


}
