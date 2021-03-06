package org.sxd.invmgmt.service.stock.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sxd.invmgmt.common.MsgEnum;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dao.stock.StockDao;
import org.sxd.invmgmt.dto.stock.StockDto;
import org.sxd.invmgmt.entity.stock.StockEntity;
import org.sxd.invmgmt.service.base.impl.BaseServiceImpl;
import org.sxd.invmgmt.service.stock.StockService;
import org.sxd.invmgmt.utils.StringUtils;

/**
 * Created by eddie on 2018/4/2.
 */
@Service
public class StockServiceImpl extends BaseServiceImpl<StockDto, StockEntity> implements StockService {
    private StockDao stockDao;

    @Autowired
    public void setStockDao(StockDao stockDao) {
        this.baseDao = stockDao;
        this.stockDao = stockDao;
    }
    public Result<Integer> createStock(StockDto stockDto) {
        if (null != stockDto
                && StringUtils.isNotBlank(stockDto.getCode())
                && StringUtils.isNotBlank(stockDto.getName())
                && StringUtils.isNotBlank(stockDto.getUnit())
                && null != stockDto.getType()) {
            if (null != stockDao.selectByCode(stockDto.getCode())) {
                return new Result<Integer>(false, "编码已存在", 0);
            }
            return this.add(stockDto);
        }
        return new Result<Integer>(false, "信息不完整", 0);
    }

    public Result<Integer> addStock(StockDto stockDto) {
        if (null != stockDto
                && null != stockDto.getId()
                && StringUtils.isNotBlank(stockDto.getCode())
                && null != stockDto.getStock()) {
            if (stockDto.getStock() < 0) {
                return new Result<Integer>(false, MsgEnum.INVALID_STOCK.getMsg(), 0);
            }
            StockDto dto = this.findById(stockDto).getObj();
            if (null == dto) {
                return new Result<Integer>(false, "货品不存在", 0);
            }
            if (stockDto.getStock() > dto.getStock()) {
                return new Result<Integer>(false, "库存不足", 0);
            }
            dto.setStock(dto.getStock() - stockDto.getStock());
            return this.edit(dto);
        }
        return new Result<Integer>(false, MsgEnum.NULL_PARAMETER.getMsg(), 0);
    }

    public Result<Integer> subStock(StockDto stockDto) {
        if (null == stockDto.getId()) {
            return new Result<Integer>(false, "id为空", 0);
        }
        StockDto dto = this.findById(stockDto).getObj();
        if (null == dto) {
            return new Result<Integer>(false, MsgEnum.NO_DATA_FOUND.getMsg(), 0);
        }
        dto.setStock(dto.getStock() - stockDto.getStock());
        return this.edit(dto);
    }

    public Result<Integer> editStock(StockDto stockDto) {
        return null;
    }

    public Result<Integer> createOrEditStock(StockDto stockDto) {
        if (null == stockDto.getCode()) {
            return new Result<Integer>(false, "编码为空", 0);
        }
        StockEntity entity = stockDao.selectByCode(stockDto.getCode());
        if (null == entity) {
            return this.createStock(stockDto);
        } else {
            return this.addStock(stockDto);
        }
    }
}
