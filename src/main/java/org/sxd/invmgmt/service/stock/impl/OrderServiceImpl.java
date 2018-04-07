package org.sxd.invmgmt.service.stock.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sxd.invmgmt.common.MsgEnum;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dao.stock.OrderDao;
import org.sxd.invmgmt.dto.stock.OrderDto;
import org.sxd.invmgmt.dto.stock.StockDto;
import org.sxd.invmgmt.entity.stock.OrderEntity;
import org.sxd.invmgmt.service.base.impl.BaseServiceImpl;
import org.sxd.invmgmt.service.stock.OrderService;
import org.sxd.invmgmt.service.stock.StockService;

import java.util.List;

/**
 * Created by eddie on 2018/4/5.
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderDto, OrderEntity> implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.baseDao = orderDao;
        this.orderDao  = orderDao;
    }

    @Autowired
    private StockService stockService;

    public Result<Integer> orderPass(Long id) {
        if (null == id) {
            return new Result<Integer>(false, MsgEnum.NULL_PARAMETER.getMsg(), 0);
        }
        OrderDto dto = new OrderDto();
        dto.setId(id);
        dto = this.findById(dto).getObj();
        if (null == dto) {
            return new Result<Integer>(false, MsgEnum.NO_DATA_FOUND.getMsg(), 0);
        }
        dto.setStatus(1);
        return this.edit(dto);
    }

    public Result<Integer> orderNotPass(Long id) {
        if (null == id) {
            return new Result<Integer>(false, MsgEnum.NULL_PARAMETER.getMsg(), 0);
        }
        OrderDto dto = new OrderDto();
        dto.setId(id);
        dto = this.findById(dto).getObj();
        if (null == dto) {
            return new Result<Integer>(false, MsgEnum.NO_DATA_FOUND.getMsg(), 0);
        }
        dto.setStatus(2);
        return this.edit(dto);
    }

    @Transactional
    public Result<Integer> orderDeliver(Long id) {
        if (null == id) {
            return new Result<Integer>(false, MsgEnum.NULL_PARAMETER.getMsg(), 0);
        }
        OrderDto dto = new OrderDto();
        dto.setId(id);
        dto = this.findById(dto).getObj();
        if (null == dto) {
            return new Result<Integer>(false, MsgEnum.NO_DATA_FOUND.getMsg(), 0);
        }
        List<Long> ids = dto.getStockIdsList();
        List<Integer> stocks = dto.getStocksList();
        StockDto stockDto = new StockDto();
        for (int i = 0; i < ids.size(); i++) {
            stockDto.setId(ids.get(i));
            stockDto.setStock(stocks.get(i));
            if(!stockService.subStock(stockDto).isSuccess()) {
                dto.setStatus(4);
                this.edit(dto);
                throw new RuntimeException("库存不足");
            }
        }
        dto.setStatus(3);
        return this.edit(dto);
    }
}
