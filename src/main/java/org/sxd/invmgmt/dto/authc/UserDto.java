package org.sxd.invmgmt.dto.authc;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.sxd.invmgmt.dto.base.Dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eddie on 2017/12/26.
 */
public class UserDto implements Dto {
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
     * 密码
     */
    private String password;

    /**
     * 名字
     */
    private String name;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 拥有的角色字符串
     */
    private String roleIds;

    /**
     * 角色列表
     */
    private List<Long> roleIdsList;

    /**
     * 是否锁定
     */
    private Boolean locked = Boolean.FALSE;

    /**
     * 删除标记
     */
    private Boolean deleted = Boolean.FALSE;

    public UserDto() {
    }

    public UserDto(Long id) {
        this.id = id;
    }

    public UserDto(String username) {
        this.username = username;
    }

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
        this.setRoleIdsList();
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (id != null ? !id.equals(userDto.id) : userDto.id != null) return false;
        if (organizationId != null ? !organizationId.equals(userDto.organizationId) : userDto.organizationId != null)
            return false;
        if (username != null ? !username.equals(userDto.username) : userDto.username != null) return false;
        if (password != null ? !password.equals(userDto.password) : userDto.password != null) return false;
        if (name != null ? !name.equals(userDto.name) : userDto.name != null) return false;
        if (salt != null ? !salt.equals(userDto.salt) : userDto.salt != null) return false;
        if (roleIds != null ? !roleIds.equals(userDto.roleIds) : userDto.roleIds != null) return false;
        if (!locked.equals(userDto.locked)) return false;
        return deleted.equals(userDto.deleted);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (roleIds != null ? roleIds.hashCode() : 0);
        result = 31 * result + locked.hashCode();
        result = 31 * result + deleted.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", salt='" + salt + '\'' +
                ", roleIds=" + roleIds +
                ", locked=" + locked +
                ", deleted=" + deleted +
                '}';
    }

    public String getCredentialsSalt() {
        return username + salt;
    }

    public UserDto setRoleIdsList() {
        if (StringUtils.isEmpty(roleIds)) {
            return this;
        }
        String[] roleIdStrs = roleIds.split(",");
        for (String roleIdStr : roleIdStrs) {
            if (!StringUtils.isEmpty(roleIdStr)) {
                getRoleIdsList().add(Long.valueOf(roleIdStr));
            }
        }
        return this;
    }

    public void setRoleIdsList(List<Long> newRoleIdsList) {
        if (CollectionUtils.isEmpty(newRoleIdsList)) {
            return;
        }
        this.roleIdsList = newRoleIdsList;
        StringBuilder str = new StringBuilder();
        for (Long roleId : newRoleIdsList) {
            str.append(roleId);
            str.append(",");
        }
        this.setRoleIds(str.toString());
    }

    public List<Long> getRoleIdsList() {
        if (roleIdsList == null) {
            roleIdsList = new ArrayList<Long>();
        }
        return roleIdsList;
    }
}
