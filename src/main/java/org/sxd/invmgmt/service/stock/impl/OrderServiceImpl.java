package org.sxd.invmgmt.service.stock.impl;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sxd.invmgmt.common.MsgEnum;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dao.stock.OrderDao;
import org.sxd.invmgmt.dto.authc.UserDto;
import org.sxd.invmgmt.dto.stock.OrderDetailDto;
import org.sxd.invmgmt.dto.stock.OrderDto;
import org.sxd.invmgmt.dto.stock.StockDto;
import org.sxd.invmgmt.entity.stock.OrderDetailEntity;
import org.sxd.invmgmt.entity.stock.OrderEntity;
import org.sxd.invmgmt.service.authc.UserService;
import org.sxd.invmgmt.service.base.impl.BaseServiceImpl;
import org.sxd.invmgmt.service.stock.OrderService;
import org.sxd.invmgmt.service.stock.StockService;
import org.sxd.invmgmt.utils.BeanCopyUtil;
import org.sxd.invmgmt.utils.DateHelper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by eddie on 2018/4/5.
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderDto, OrderEntity> implements OrderService {

    private OrderDao orderDao;

    @Autowired
    private StockService stockService;

    @Autowired
    private UserService userService;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.baseDao = orderDao;
        this.orderDao  = orderDao;
    }

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

    public Result<OrderDetailDto> orderDetail(OrderDto orderDto) {
        baseDaoCheck();
        dtoCheck(orderDto);
        if (null == orderDto.getId()) {
            return new Result<OrderDetailDto>(false, MsgEnum.WRONG_PASSWORD.getMsg(), null);
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDto.getId());
        OrderDetailEntity orderDetailEntity = orderDao.selectDetail(orderEntity);
        OrderDetailDto orderDetailDto = detailEntityToDetailDto(orderDetailEntity);
        List<StockDto> list = orderDetailDto.getStockIdsList().stream().map((id) -> stockService.findById(new StockDto(id)).getObj()).collect(Collectors.toList());
        orderDetailDto.setStockDetailList(list);
        orderDetailDto.setDateStr(DateHelper.dateToString(orderDetailDto.getCreateDate(), "yyyy-MM-dd hh:mm:ss"));
        return new Result<OrderDetailDto>(true, MsgEnum.OPRATION_SUCCEED.getMsg(), orderDetailDto);
    }

    @Override
    public Result<Integer> addOrder(OrderDto orderDto) {
        String currentUserName = (String) SecurityUtils.getSubject().getPrincipal();
        UserDto userDto = userService.findByUsername(currentUserName).getObj();
        orderDto.setStatus(0);
        orderDto.setUserId(userDto.getId());
        orderDto.setUsername(userDto.getUsername());
        orderDto.setDeptId(userDto.getOrganizationId());
        return this.add(orderDto);
    }

    protected OrderDetailDto detailEntityToDetailDto(OrderDetailEntity entity) {
        if (entity != null) {
            OrderDetailDto dto = new OrderDetailDto();
            BeanCopyUtil.copyProperties(dto, entity);
            return dto;
        }
        return null;
    }


}
