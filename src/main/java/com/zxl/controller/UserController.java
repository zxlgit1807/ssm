package com.zxl.controller;

import com.zxl.model.User;
import com.zxl.service.IUserService;
import com.zxl.tools.CryptoUtils;
import com.zxl.vo.ResultVo;
import com.zxl.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 用户管理
 */
@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 注册用户
     * @param userVO
     * @return
     */
    @RequestMapping("/registerUser")
    @ResponseBody
    private ResultVo registerUser(UserVO userVO) {
        ResultVo resultVo = new ResultVo();
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        user.setLoginPwd(CryptoUtils.EncoderByMd5(user.getLoginPwd()));
        userService.saveUser(user);
        return resultVo;
    }
}
