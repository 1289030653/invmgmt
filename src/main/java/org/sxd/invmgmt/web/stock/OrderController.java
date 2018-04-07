package org.sxd.invmgmt.web.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.stock.OrderDto;
import org.sxd.invmgmt.entity.base.Pagination;
import org.sxd.invmgmt.service.stock.OrderService;

import java.util.List;

/**
 * Created by eddie on 2018/4/5.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public Result<List<OrderDto>> getList(OrderDto orderDto, Pagination pagination) {
        if (null == pagination || !pagination.isValid()) {
            pagination = Pagination.getDefaultPagination();
        }
        return orderService.findByPage(orderDto, pagination);
    }

    @PostMapping("/orders")
    public Result<Integer> createOrder(OrderDto orderDto) {
        return orderService.add(orderDto);
    }

    @DeleteMapping("/orders/{id}")
    public Result<Integer> deleteOrder(@PathVariable Long id) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        return orderService.remove(orderDto);
    }

    @PutMapping("/orders")
    public Result<Integer> editOrder(OrderDto oderDto) {
        return orderService.edit(oderDto);
    }

    @PutMapping("/orders/check")
    public Result<Integer> checkOrder(OrderDto orderDto) {
        if (1 == orderDto.getStatus()) {
            return orderService.orderPass(orderDto.getId());
        }
        return orderService.orderNotPass(orderDto.getId());
    }

    @PutMapping("/orders/deliver")
    public Result<Integer> deliver(OrderDto orderDto) {
        return orderService.orderDeliver(orderDto.getId());
    }
}
