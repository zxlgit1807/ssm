package com.zxl.service.impl;

import com.zxl.dao.IUserDao;
import com.zxl.model.User;
import com.zxl.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User getTest() {
        User user = userDao.selectByPrimaryKey( "1" );
        return user;
    }

}
