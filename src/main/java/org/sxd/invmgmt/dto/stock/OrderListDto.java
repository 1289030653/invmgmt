package org.sxd.invmgmt.dto.stock;

import org.sxd.invmgmt.dto.base.Dto;

import java.util.Date;
import java.util.List;

/**
 * @Author: ShenXudong
 * @Description:
 * @Date: 2018/4/8 11:36
 */
public class OrderListDto implements Dto {
    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    private String username;

    /**
     * 部门id
     */
    private Long deptId;

    private String deptName;
    /**
     * 材料id
     */
    private String stockIds;

    private List<Long> stockIdsList;
    /**
     * 数量
     */
    private String stocks;

    private List<Integer> stocksList;

    /**
     * status
     * 0 审核通过； 1 审核不通过； 2 已经出库； 3 出库失败
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
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getStockIds() {
        return stockIds;
    }

    public void setStockIds(String stockIds) {
        this.stockIds = stockIds;
    }

    public List<Long> getStockIdsList() {
        return stockIdsList;
    }

    public void setStockIdsList(List<Long> stockIdsList) {
        this.stockIdsList = stockIdsList;
    }

    public String getStocks() {
        return stocks;
    }

    public void setStocks(String stocks) {
        this.stocks = stocks;
    }

    public List<Integer> getStocksList() {
        return stocksList;
    }

    public void setStocksList(List<Integer> stocksList) {
        this.stocksList = stocksList;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
