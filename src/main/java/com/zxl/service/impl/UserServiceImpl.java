package com.zxl.service.impl;

import com.zxl.dao.UserMapper;
import com.zxl.model.User;
import com.zxl.model.UserExample;
import com.zxl.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey( userId );
    }

    @Override
    public User getUserByLoginName(String userName) {
        User user = null;
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(example);
        if (users != null && !users.isEmpty()) {
            user = users.get(0);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        user.setCreateTime(new Date());
        user.setId(UUID.randomUUID().toString());
        userMapper.insert(user);
    }

}
