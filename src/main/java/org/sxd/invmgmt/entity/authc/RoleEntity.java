package org.sxd.invmgmt.entity.authc;

import org.sxd.invmgmt.entity.base.Entity;

import java.util.List;

/**
 * Created by eddie on 2017/12/25.
 */
public class RoleEntity extends Entity {
    /**
     * 编号
     */
    private Long id;

    /**
     * 角色标识 程序中判断使用,如"admin"
     */
    private String role;

    /**
     * 角色描述,UI界面显示使用
     */
    private String description;

    /**
     * 拥有的资源
     */
    private String resourceIds;

    /**
     * 是否可用
     */
    private Boolean available = Boolean.FALSE;

    /**
     * 是否删除
     */
    private Boolean deleted = Boolean.FALSE;

    public RoleEntity() {

    }

    public RoleEntity(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
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

        RoleEntity role1 = (RoleEntity) o;

        if (id != null ? !id.equals(role1.id) : role1.id != null) return false;
        if (role != null ? !role.equals(role1.role) : role1.role != null) return false;
        if (description != null ? !description.equals(role1.description) : role1.description != null) return false;
        if (resourceIds != null ? !resourceIds.equals(role1.resourceIds) : role1.resourceIds != null) return false;
        if (!available.equals(role1.available)) return false;
        return deleted.equals(role1.deleted);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (resourceIds != null ? resourceIds.hashCode() : 0);
        result = 31 * result + available.hashCode();
        result = 31 * result + deleted.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", resourceIds=" + resourceIds +
                ", available=" + available +
                ", deleted=" + deleted +
                '}';
    }
}
