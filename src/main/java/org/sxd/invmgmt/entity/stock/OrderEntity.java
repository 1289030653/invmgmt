package org.sxd.invmgmt.entity.stock;

import org.sxd.invmgmt.entity.base.Entity;

import java.util.Date;

/**
 * Created by eddie on 2018/4/5.
 */
public class OrderEntity extends Entity {
    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 材料id
     */
    private String stockIds;

    /**
     * 数量
     */
    private String stocks;

    /**
     * status
     * 0 待审核； 1 审核通过； 2 审核不通过； 3 已经出库； 4 出库失败
     */
    private Integer status;

    /**
     * 删除标记
     */
    private Boolean deleted = Boolean.FALSE;

    /**
     * 描述
     */
    private String msg;

    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getStockIds() {
        return stockIds;
    }

    public void setStockIds(String stockIds) {
        this.stockIds = stockIds;
    }

    public String getStocks() {
        return stocks;
    }

    public void setStocks(String stocks) {
        this.stocks = stocks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
