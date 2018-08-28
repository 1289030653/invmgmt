package org.sxd.invmgmt.service.stock;

import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.stock.OrderDetailDto;
import org.sxd.invmgmt.dto.stock.OrderDto;
import org.sxd.invmgmt.dto.stock.StockDto;
import org.sxd.invmgmt.service.base.BaseService;

/**
 * Created by eddie on 2018/4/5.
 */
public interface OrderService extends BaseService<OrderDto> {
    /**
     * 审核通过
     */
    Result<Integer> orderPass(Long id);

    /**
     * 审核失败
     */
    Result<Integer> orderNotPass(Long id);

    /**
     * 按领料单出库
     */
    Result<Integer> orderDeliver(Long id);

    Result<OrderDetailDto> orderDetail(OrderDto orderDto);

    Result<Integer> addOrder(OrderDto orderDto);
}
