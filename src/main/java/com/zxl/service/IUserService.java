package com.zxl.service;

import com.zxl.model.User;

public interface IUserService {
    /**
     * 根据主键获取用户
     * @param userId
     * @return
     */
    User getUserById(String userId);
}
