package com.example.service;

import com.example.controller.BaseTest;
import com.example.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author lkmc2
 * @date 2018/9/28
 * @description
 */
public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void queryUsernameIsExist() {
        boolean isExist = userService.queryUsernameIsExist("abc");

        assertTrue(isExist);
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setUsername("Ticket");
        user.setPassword("123456");
        user.setNickname("Luck");

        assertTrue(userService.saveUser(user));
    }

    @Test
    public void queryUserForLogin() {
        User user = new User();
        user.setUsername("Ticket");
        user.setPassword("123456");

        assertNotNull(userService.queryUserForLogin(user.getUsername(), user.getPassword()));
    }

}