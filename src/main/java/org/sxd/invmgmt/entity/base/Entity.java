package org.sxd.invmgmt.entity.base;

import java.io.Serializable;

/**
 * Created by eddie on 2017/12/19.
 */
public class Entity{
    private Integer pageSize = 10;

    private Integer start = 0;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}
