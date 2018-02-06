package org.sxd.invmgmt.web.authc;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sxd.invmgmt.common.MsgEnum;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.authc.UserDto;
import org.sxd.invmgmt.service.authc.UserService;
import org.sxd.invmgmt.web.base.BaseController;

import java.util.List;

/**
 * Created by eddie on 2018/02/06.
 * 对用户CRUD操作
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequiresRoles("admin")
    @GetMapping("/list")
    public Result<List<UserDto>> listAll() {
        Result<List<UserDto>> result;
        result = userService.findAll();
        if (result == null) {
            result = new Result<List<UserDto>>(false, MsgEnum.OPRATION_FAILED.toString(), null);
        }
        return result;
    }
}
