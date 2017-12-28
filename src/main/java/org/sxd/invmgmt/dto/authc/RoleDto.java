package org.sxd.invmgmt.dto.authc;

import org.sxd.invmgmt.dto.base.Dto;

/**
 * Created by eddie on 2017/12/28.
 */
public class RoleDto implements Dto {
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

    public RoleDto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleDto roleDto = (RoleDto) o;

        if (id != null ? !id.equals(roleDto.id) : roleDto.id != null) return false;
        if (role != null ? !role.equals(roleDto.role) : roleDto.role != null) return false;
        if (description != null ? !description.equals(roleDto.description) : roleDto.description != null) return false;
        if (resourceIds != null ? !resourceIds.equals(roleDto.resourceIds) : roleDto.resourceIds != null) return false;
        return available.equals(roleDto.available);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (resourceIds != null ? resourceIds.hashCode() : 0);
        result = 31 * result + available.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", resourceIds='" + resourceIds + '\'' +
                ", available=" + available +
                '}';
    }
}
