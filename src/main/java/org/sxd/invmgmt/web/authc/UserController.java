package org.sxd.invmgmt.web.authc;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sxd.invmgmt.common.MsgEnum;
>>>>>>> c8c1653dced2d8abb8af1fbd16bc2dc138a6628f
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.authc.UserDto;
import org.sxd.invmgmt.service.authc.UserService;
import org.sxd.invmgmt.web.base.BaseController;

import java.util.List;

/**
<<<<<<< HEAD
 * Created by eddie on 2018/2/4.
 */
@RestController
@RequestMapping(value = "/user")
=======
 * Created by eddie on 2018/02/06.
 * 对用户CRUD操作
 */
@RestController
@RequestMapping("/user")
>>>>>>> c8c1653dced2d8abb8af1fbd16bc2dc138a6628f
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequiresRoles("admin")
<<<<<<< HEAD
    @RequestMapping(value = "/list")
    public Result<List<UserDto>> list() {
        return userService.findAll();
    }


=======
    @GetMapping("/list")
    public Result<List<UserDto>> listAll() {
        Result<List<UserDto>> result;
        result = userService.findAll();
        if (result == null) {
            result = new Result<List<UserDto>>(false, MsgEnum.OPRATION_FAILED.toString(), null);
        }
        return result;
    }
>>>>>>> c8c1653dced2d8abb8af1fbd16bc2dc138a6628f
}
