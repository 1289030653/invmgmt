package org.sxd.invmgmt.service.authc;

import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.authc.UserDto;
import org.sxd.invmgmt.service.base.BaseService;

import java.util.Set;

/**
 * Created by eddie on 2017/12/26.
 */
public interface UserService extends BaseService<UserDto> {
    /**
     * 创建新用户
     * @param userDto
     * @return
     */
    Result<Integer> createUser(UserDto userDto);

    /**
     * 修改密码
     * @param userDto
     * @return
     */
    Result<Integer> changePassword(Long userId, String newPassword);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    Result<UserDto> findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 根据用户名查询其权限
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);
}
