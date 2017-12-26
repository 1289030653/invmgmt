package org.sxd.invmgmt.entity.authc;

import org.sxd.invmgmt.entity.base.Entity;

/**
 * Created by eddie on 2017/12/25.
 */
public class ResourceEntity implements Entity {
    private Long id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源类型
     */
    private ResourceType type = ResourceType.menu;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限字符串
     */
    private String permission;

    /**
     * 父编号
     */
    private Long parentId;

    /**
     * 父编号列表
     */
    private String parentIds;

    /**
     * 是否可用
     */
    private Boolean available = Boolean.FALSE;

    /**
     * 是否删除
     */
    private Boolean deleted = Boolean.FALSE;

    public static enum ResourceType {
        menu("菜单"), button("按钮");

        private final String info;
        private ResourceType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }

    public ResourceEntity() {

    }

    public ResourceEntity(String name, ResourceType type, String url, String permission, Long parentId, String parentIds, Boolean available) {
        this.name = name;
        this.type = type;
        this.url = url;
        this.permission = permission;
        this.parentId = parentId;
        this.parentIds = parentIds;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
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

        ResourceEntity resource = (ResourceEntity) o;

        if (id != null ? !id.equals(resource.id) : resource.id != null) return false;
        if (name != null ? !name.equals(resource.name) : resource.name != null) return false;
        if (type != resource.type) return false;
        if (url != null ? !url.equals(resource.url) : resource.url != null) return false;
        if (permission != null ? !permission.equals(resource.permission) : resource.permission != null) return false;
        if (parentId != null ? !parentId.equals(resource.parentId) : resource.parentId != null) return false;
        if (parentIds != null ? !parentIds.equals(resource.parentIds) : resource.parentIds != null) return false;
        if (!available.equals(resource.available)) return false;
        return deleted.equals(resource.deleted);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (permission != null ? permission.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (parentIds != null ? parentIds.hashCode() : 0);
        result = 31 * result + available.hashCode();
        result = 31 * result + deleted.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", available=" + available +
                ", deleted=" + deleted +
                '}';
    }
}
