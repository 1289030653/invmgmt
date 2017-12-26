package org.sxd.invmgmt.entity.base;

/**
 * Created by eddie on 2017/12/25.
 */
public abstract class AbstractEntity implements Entity {
    /**
     * 是否删除
     */
    protected Boolean deleted = Boolean.FALSE;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
