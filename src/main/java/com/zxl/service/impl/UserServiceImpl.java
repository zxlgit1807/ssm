package com.zxl.service.impl;

import com.zxl.dao.UserMapper;
import com.zxl.model.User;
import com.zxl.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey( userId );
    }

}
