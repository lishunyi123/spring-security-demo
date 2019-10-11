package com.lishunyi.securitylogindb.service.impl;

import com.lishunyi.securitylogindb.entity.User;
import com.lishunyi.securitylogindb.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void insert() {
        User user = new User(1L, "李顺仪", "123", "顺顺");
        userService.insert(user);
    }

    @Test
    public void findByUsername() {
        User user = userService.findByUsername("李顺仪");
        Assert.assertNotNull(user);
    }
}