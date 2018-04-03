package org.sxd.invmgmt.service.authc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sxd.invmgmt.common.MsgEnum;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dao.authc.UserDao;
import org.sxd.invmgmt.dto.authc.UserDto;
import org.sxd.invmgmt.dto.authc.UserListDto;
import org.sxd.invmgmt.entity.authc.UserEntity;
import org.sxd.invmgmt.service.authc.RoleService;
import org.sxd.invmgmt.service.authc.UserService;
import org.sxd.invmgmt.service.base.impl.BaseServiceImpl;

import java.util.Collections;
import java.util.Set;

/**
 * Created by eddie on 2017/12/26.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDto, UserEntity> implements UserService {

    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordHelper passwordHelper;

    @Autowired
    public void setUserDao(UserDao userDao) {
        super.baseDao = userDao;
        this.userDao = userDao;
    }

    public Result<Integer> editUser(UserDto userDto) {
        if (userDto.getId() == null && userDto.getUsername() == null) {
            return new Result(false, "id和用户名为空", 0);
        }
        UserEntity userEntity = dtoToEntity(userDto);
        if (userDto.getId() != null) {
            if (userDao.selectById(userEntity) != null) {
                return this.edit(userDto);
            } else {
                return new Result<Integer>(false, "操作失败，该用户不存在", 0);
            }
        } else {
            if (userDao.selectByUsername(userDto.getUsername()) != null) {
                return this.edit(userDto);
            } else {
                return new Result<Integer>(false, "操作失败，该用户不存在", 0);
            }
        }

    }

    public Result<UserListDto> createUser(UserDto userDto) {
        Result<UserListDto> result;
        if (userDto != null) {
            String username = userDto.getUsername();
            String password = userDto.getPassword();
            //用户名密码不能为空
            if (username == null || password == null || "".equals(username) || "".equals(password)) {
                return new Result<UserListDto>(false, "用户名或密码不能为空", null);
            }
            //用户名是否已经存在
            UserEntity userEntity = userDao.selectByUsername(username);
            if (userEntity != null) {
                return new Result<UserListDto>(false, "用户名已经存在", null);
            }

            //新增用户
            //加密密码
            passwordHelper.encryptPassword(userDto);
            this.add(userDto);
            userDto = this.findByUsername(username).getObj();
            UserListDto userListDto = new UserListDto();
            userListDto.setId(userDto.getId());
            userListDto.setUsername(userDto.getUsername());
            userListDto.setName(userDto.getName());
            userListDto.setRoleIdsList(userDto.getRoleIdsList());
            userListDto.setLocked(userDto.getLocked());
            userListDto.setOrganizationId(userDto.getOrganizationId());
            return new Result<UserListDto>(true, "操作成功", userListDto);
        } else {
            result = new Result<UserListDto>(false, MsgEnum.NULL_PARAMETER.getMsg(), null);
        }
        return result;
    }

    public Result<Integer> changePassword(Long userId, String newPassword) {
        Result<Integer> result;
        UserDto userDto = new UserDto(userId);
        Result<UserDto> res = this.findById(userDto);
        if (res.isSuccess()) {
            userDto = res.getObj();
            passwordHelper.encryptPassword(userDto);
            result = this.edit(userDto);
        } else {
            result = new Result<Integer>(false, MsgEnum.OPRATION_FAILED.getMsg(), null);
        }
        return result;
    }

    public Result<UserDto> findByUsername(String username) {
        System.out.println("username:" + username);
        Result<UserDto> result;
        UserEntity userEntity = userDao.selectByUsername(username);
        if (userEntity != null) {
            result = new Result<UserDto>(
                    true,
                    MsgEnum.OPRATION_SUCCEED.getMsg(),
                    entityToDto(userEntity).setRoleIdsList());
        } else {
            result = new Result<UserDto>(false, MsgEnum.NULL_RESULT.getMsg(), null);
        }
        return result;
    }

    public Set<String> findRoles(String username) {
        UserDto userDto = this.findByUsername(username).getObj();
        if (userDto == null) {
            return Collections.emptySet();
        }
        return roleService.findRoles(userDto.getRoleIdsList().toArray(new Long[0]));
    }

    public Set<String> findPermissions(String username) {
        return null;
    }
}
