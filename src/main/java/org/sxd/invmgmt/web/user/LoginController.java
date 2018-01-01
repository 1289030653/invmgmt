package org.sxd.invmgmt.web.user;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.web.base.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by eddie on 2017/12/31.
 */
@RestController
public class LoginController extends BaseController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<Object> login() {
        return null;
    }

    @RequestMapping(value = "/logout")
    public Result<Object> logout() {
        SecurityUtils.getSubject().logout();
        return new Result<Object>(true, "退出成功", null);
    }
    @RequestMapping(value = "/success")
    public Result<Object> success(HttpServletRequest request, HttpServletResponse response,
                                String username, String password, String rememberMe) {
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
