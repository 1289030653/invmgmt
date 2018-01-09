package org.sxd.invmgmt.web.authc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.authc.CurrentUser;
import org.sxd.invmgmt.dto.authc.UserDto;
import org.sxd.invmgmt.service.authc.UserService;
import org.sxd.invmgmt.web.base.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by eddie on 2017/12/31.
 */
@RestController
public class LoginController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<CurrentUser> login(String password, String username, String rememberMe) {
        Result<CurrentUser> result;
        System.out.println(rememberMe);
        String error = null;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token =
                new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            error = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
        } catch (AuthenticationException e) {
            error = "其他错误";
            e.printStackTrace();
        }
        if (error != null) {
            result = new Result<CurrentUser>(false, error, null);
        } else {
            UserDto userDto = userService.findByUsername(username).getObj();
            CurrentUser currentUser = new CurrentUser(userDto);
            result = new Result<CurrentUser>(true, "登陆成功", currentUser);
        }
        return result;
    }

    @RequestMapping(value = "/logout")
    public Result<Object> logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            return new Result<Object>(true, "退出成功", null);
        }
        return new Result<Object>(false, "尚未登陆", null);
    }
    @RequestMapping(value = "/success")
    public Result<Object> success(HttpServletRequest request, HttpServletResponse response) {
        Result<Object> result;
        Object principal = SecurityUtils.getSubject().getPrincipal();
        if (principal == null) {
            result = new Result<Object>(false, "登陆失败", null);
        } else {
            result = new Result<Object>(true, "登陆成功", null);
        }
        return result;
    }

    @RequestMapping(value = "/unauthorized")
    public Result<Object> unauthorized() {
        return new Result<Object>(false, "未登陆", null);
    }

}
