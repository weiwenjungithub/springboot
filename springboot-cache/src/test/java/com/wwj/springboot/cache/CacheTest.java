package com.wwj.springboot.cache;

import com.wwj.springboot.model.User;
import com.wwj.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author weiwenjun
 * @since 2019/4/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class CacheTest {

    @Resource
    private UserService userService;

    @Test
    public void findUserTest() {
        for (int i = 0; i < 3; i++) {
            System.out.println("第" + i + "次");
            User user = userService.findUser();
            System.out.println(user);
        }
    }

    @Test
    public void updateUserTest() {
        userService.updateUser();
        User user = userService.findUser();
        System.out.println(user);
    }

    @Test
    public void clearUserTest() {
        userService.clearUser();
        User user = userService.findUser();
        System.out.println(user);
    }

}
