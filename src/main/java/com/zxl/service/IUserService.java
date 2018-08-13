package com.zxl.service;

import com.zxl.model.User;

public interface IUserService {
    /**
     * 根据主键获取用户
     * @param userId
     * @return
     */
    User getUserById(String userId);

    /**
     * 通过用户名获取用户
     * @param userName
     * @return
     */
    User getUserByLoginName(String userName);

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
}
