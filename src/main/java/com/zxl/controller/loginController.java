package com.zxl.controller;

import com.zxl.vo.LoginVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description 登录
 * @Author ZXL
 * @Date 2018/8/2
 **/
@Controller
@RequestMapping("/loginController")
public class loginController {

    /**
     * 登录方法
     * @param loginVO
     */
    public ModelAndView login(LoginVO loginVO) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(loginVO.getUserName(), loginVO.getUserPwd()));
        }catch (Exception e){
            e.getMessage();
        }
        return new ModelAndView("login.html");
    }
}
