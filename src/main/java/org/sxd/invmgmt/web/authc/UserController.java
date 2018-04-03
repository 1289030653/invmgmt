package org.sxd.invmgmt.web.authc;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.authc.UserDto;
import org.sxd.invmgmt.dto.authc.UserListDto;
import org.sxd.invmgmt.entity.base.Pagination;
import org.sxd.invmgmt.service.authc.UserService;
import org.sxd.invmgmt.web.base.BaseController;

import java.util.List;

/**
 * Created by eddie on 2018/2/4.
 */
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @param pagination
     * @return
     */
    @RequiresRoles("admin")
    @GetMapping("/users")
    public Result<List<UserDto>> getList(UserDto userDto, Pagination pagination) {
        if (pagination == null || ! pagination.isValid()) {
            pagination = new Pagination();
        }
        return userService.findByPage(userDto, pagination);
    }

    /**
     * 增加一个用户
     * @param user
     * @return
     */
    @RequiresRoles("admin")
    @PostMapping("/users")
    public Result<UserListDto> createUser(UserDto user) {

        System.out.println(user.getUsername());
        if (user.getUsername() == null) {
            return new Result<UserListDto>(false, "用户名不可为空", null);
        }
        if (user.getPassword() == null) {
            return new Result<UserListDto>(false, "密码不可为空", null);
        }
        return userService.createUser(user);
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @RequiresRoles("admin")
    @DeleteMapping("/users/{id}")
    public Result<Integer> deleteUser(@PathVariable Long id) {
        UserDto user = new UserDto(id);
        return userService.remove(user);
    }

    /**
     * 根据用户id查找用户
     * @param id
     * @return
     */
    @RequiresRoles("admin")
    @GetMapping("/users/{id}")
    public Result<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = new UserDto(id);
        return userService.findById(user);
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @RequiresRoles("admin")
    @GetMapping("/users/{username}")
    public Result<UserDto> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @RequiresRoles("admin")
    @PutMapping("/users")
    public Result<Integer> editUser(UserDto user) {
        return userService.editUser(user);
    }


}
