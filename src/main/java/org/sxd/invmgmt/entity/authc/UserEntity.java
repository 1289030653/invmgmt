package org.sxd.invmgmt.entity.authc;


import org.sxd.invmgmt.entity.base.Entity;

/**
 * Created by eddie on 2017/12/25.
 * 用户实体类
 */
public class UserEntity extends Entity {
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
     * 拥有的角色列表
     */
    private String roleIds;

    /**
     * 是否锁定
     */
    private Boolean locked = Boolean.FALSE;

    /**
     * 删除标记
     */
    private Boolean deleted = Boolean.FALSE;

    public UserEntity() {
    }

    public UserEntity(String username) {
        this.username = username;
    }

    public UserEntity(String username, String password) {
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

        UserEntity user = (UserEntity) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (organizationId != null ? !organizationId.equals(user.organizationId) : user.organizationId != null)
            return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (salt != null ? !salt.equals(user.salt) : user.salt != null) return false;
        if (roleIds != null ? !roleIds.equals(user.roleIds) : user.roleIds != null) return false;
        if (!locked.equals(user.locked)) return false;
        return deleted.equals(user.deleted);
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

}
