package org.sxd.invmgmt.service.authc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sxd.invmgmt.dao.authc.RoleDao;
import org.sxd.invmgmt.dto.authc.RoleDto;
import org.sxd.invmgmt.entity.authc.RoleEntity;
import org.sxd.invmgmt.service.authc.RoleService;
import org.sxd.invmgmt.service.base.impl.BaseServiceImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eddie on 2017/12/30.
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleDto, RoleEntity> implements RoleService {
    @Autowired
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        super.baseDao = roleDao;
        this.roleDao = roleDao;
    }


    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        RoleEntity roleEntity;
        for (Long roleId : roleIds) {
            roleEntity = new RoleEntity();
            roleEntity.setId(roleId);
            roleEntity = roleDao.selectById(roleEntity);
            if (roleEntity != null) {
                roles.add(roleEntity.getRole());
            }
        }
        return roles;
    }

    public Set<String> findPermissions(Long... roleIds) {
        return null;
    }
}
