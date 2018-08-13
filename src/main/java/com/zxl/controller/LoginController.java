package com.zxl.controller;

import com.zxl.tools.exception.MyException;
import com.zxl.vo.LoginVO;
import com.zxl.vo.ResultVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    /**
     * 登录方法
     * @param loginVO
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVo login(LoginVO loginVO) {
        ResultVo resultVo = new ResultVo();
        Subject subject = SecurityUtils.getSubject();
        try {
            //subject.login(new UsernamePasswordToken(loginVO.getUserName(), loginVO.getUserPwd()));
            subject.login(new UsernamePasswordToken("123", "123"));
        }catch (Exception e){
            throw new MyException("账号或密码错误");
        }
        return resultVo;
    }
}