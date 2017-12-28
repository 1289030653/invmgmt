package org.sxd.invmgmt.service.authc;

import org.sxd.invmgmt.dto.authc.RoleDto;
import org.sxd.invmgmt.service.base.BaseService;

import java.util.Set;

/**
 * Created by eddie on 2017/12/28.
 */
public interface RoleService extends BaseService<RoleDto> {
    /**
     * 根据角色标号返回角色标识符
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 根据角色编号返回权限字符串列表
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long... roleIds);
}
