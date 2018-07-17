package com.zxl.service;

import com.zxl.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Description userService测试类
 * @Author ZXL
 * @Date 2018/7/17
 **/
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = { "classpath*:/spring/applicationcontext-base.xml", "classpath*:/spring/applicationcontext-database.xml", "classpath*:/spring/springmvc-context.xml" })
public class UserServiceTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void getUserById(String userId) {
        userMapper.selectByPrimaryKey( userId );
        System.out.println("1");
    }
}
