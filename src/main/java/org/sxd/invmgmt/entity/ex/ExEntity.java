package org.sxd.invmgmt.entity.ex;

import org.sxd.invmgmt.entity.base.Entity;

/**
 * Created by eddie on 2017/12/19.
 */
public class ExEntity implements Entity {
    private Integer id;
    private String msg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
