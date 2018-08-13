package com.zxl.tools;

import com.zxl.model.User;
import com.zxl.service.IUserService;
import com.zxl.tools.exception.MyException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description 自定义的shiro realm
 * @Author ZXL
 * @Date 2018/8/2
 **/
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;

    @Override
    public String getName() {
        return "myRealm";
    }
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String)authenticationToken.getPrincipal();
        if (StringUtils.isBlank(userName)) {
            throw new MyException("用户名不能为空");
        }
        User user = userService.getUserByLoginName(userName);
        if (user != null) {
            throw new MyException("密码不能为空");
        }
        return new SimpleAuthenticationInfo(user, user.getLoginPwd(), getName());
    }
}
