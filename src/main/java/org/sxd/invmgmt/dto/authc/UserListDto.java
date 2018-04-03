package org.sxd.invmgmt.dto.authc;

import org.sxd.invmgmt.dto.base.Dto;

import java.util.List;

/**
 * Created by eddie on 2018/3/31.
 */
public class UserListDto implements Dto {
    /**
     * 编号
     */
    private Long id;

    /**
     * 部门/组织编号
     */
    private Long organizationId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 名字
     */
    private String name;

    /**
     * 角色列表
     */
    private List<Long> roleIdsList;

    /**
     * 是否锁定
     */
    private Boolean locked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getRoleIdsList() {
        return roleIdsList;
    }

    public void setRoleIdsList(List<Long> roleIdsList) {
        this.roleIdsList = roleIdsList;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}
