package com.zxl.controller;

import com.zxl.tools.exception.MyException;
import com.zxl.vo.LoginVO;
import com.zxl.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description TODD
 * @Author ZXL
 * @Date 2018/8/6
 **/
@Controller
@RequestMapping("/loginController")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    /**
     * 登录方法
     * @param loginVO
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVo login(LoginVO loginVO) {
        ResultVo resultVo = new ResultVo();
        if (StringUtils.isBlank(loginVO.getUserName())) {
            throw new MyException("登录名不能为空");
        }
        if (StringUtils.isBlank(loginVO.getUserPwd())) {
            throw new MyException("密码不能为空");
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(loginVO.getUserName(), loginVO.getUserPwd()));
        } catch (Exception e) {
            logger.error("登录名或者密码错误：{}", e);
            throw new MyException("登录名或者密码错误");
        }
        return resultVo;
    }
}