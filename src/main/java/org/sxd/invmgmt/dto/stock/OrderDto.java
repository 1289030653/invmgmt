package org.sxd.invmgmt.dto.stock;

import org.springframework.util.StringUtils;
import org.sxd.invmgmt.dto.base.Dto;
import org.sxd.invmgmt.entity.base.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by eddie on 2018/4/5.
 */
public class OrderDto implements Dto {
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

    private List<Long> stockIdsList;

    /**
     * 数量
     */
    private String stocks;

    private List<Integer> stocksList;

    /**
     * status
     * 0 待舍批； 1 审核通过； 1 审核不通过；3 已经出库； 4 出库失败
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

    private String username;

    private String dateStr;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

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
        this.userId = userId;
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

    public List<Long> getStockIdsList() {
        this.setStockIdsList(this.getLongList(this.stockIds));
        return stockIdsList;
    }

    public void setStockIdsList(List<Long> stockIdsList) {
        this.stockIdsList = stockIdsList;
    }

    public List<Integer> getStocksList() {
        this.setStocksList(this.getIntegerList(this.stocks));
        return stocksList;
    }

    public void setStocksList(List<Integer> stocksList) {
        this.stocksList = stocksList;
    }

    public List<Long> getLongList(String listStr) {
        if (StringUtils.isEmpty(listStr)) {
            return null;
        }
        List<Long> newList = new ArrayList<Long>();
        String[] strs = listStr.split(",");
        for (String str : strs) {
            newList.add(Long.valueOf(str));
        }
        return newList;
    }
    public List<Integer> getIntegerList(String listStr) {
        if (StringUtils.isEmpty(listStr)) {
            return null;
        }
        List<Integer> newList = new ArrayList<Integer>();
        String[] strs = listStr.split(",");
        for (String str : strs) {
            newList.add(Integer.valueOf(str));
        }
        return newList;
    }
}
