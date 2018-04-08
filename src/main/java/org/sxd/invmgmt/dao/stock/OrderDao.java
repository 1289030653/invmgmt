package org.sxd.invmgmt.dao.stock;

import org.sxd.invmgmt.dao.base.BaseDao;
import org.sxd.invmgmt.dto.stock.OrderDto;
import org.sxd.invmgmt.entity.stock.OrderDetailEntity;
import org.sxd.invmgmt.entity.stock.OrderEntity;

/**
 * Created by eddie on 2018/4/5.
 */
public interface OrderDao extends BaseDao<OrderEntity> {
    OrderDetailEntity selectDetail(OrderEntity orderEntity);
}
