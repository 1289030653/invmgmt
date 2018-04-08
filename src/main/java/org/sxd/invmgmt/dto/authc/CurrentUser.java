package org.sxd.invmgmt.dto.authc;

import org.sxd.invmgmt.dto.base.Dto;

/**
 * Created by eddie on 2018/1/6.
 */
public class CurrentUser implements Dto {
    /**
     * 编号
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 名字
     */
    private String name;

    private String roleIds;

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public CurrentUser() {}

    public CurrentUser(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public CurrentUser(UserDto userDto) {
        this(userDto.getId(), userDto.getUsername(), userDto.getName());
        this.roleIds = userDto.getRoleIds();
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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
}
