package org.sxd.invmgmt.dto.stock;

import org.sxd.invmgmt.dto.base.Dto;

/**
 * Created by eddie on 2018/4/2.
 */
public class StockDto implements Dto {
    /**
     * id
     */
    private Long id;
    /**
     * 编号
     */
    private String code;
    /**
     * 类别
     */
    private Integer type;
    /**
     * 名称
     */
    private String name;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 单位
     */
    private String unit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
