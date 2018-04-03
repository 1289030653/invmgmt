package org.sxd.invmgmt.dto.authc;

import org.sxd.invmgmt.dto.base.Dto;

/**
 * Created by eddie on 2018/3/31.
 */
public class UserInfoDto implements Dto {
    /**
     * 用户名
     */
    private String username;
    /**
     * 名字
     */
    private String name;

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
