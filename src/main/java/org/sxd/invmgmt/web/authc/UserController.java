package org.sxd.invmgmt.web.authc;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.sxd.invmgmt.common.MsgEnum;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.authc.UserDto;
import org.sxd.invmgmt.service.authc.UserService;
import org.sxd.invmgmt.web.base.BaseController;

import java.util.List;

/**
 * Created by eddie on 2018/2/4.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequiresRoles("admin")
    @RequestMapping(value = "/list")
    public Result<List<UserDto>> list() {
        return userService.findAll();
    }
}
