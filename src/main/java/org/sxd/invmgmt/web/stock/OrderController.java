package org.sxd.invmgmt.web.stock;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sxd.invmgmt.common.MsgEnum;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.authc.UserDto;
import org.sxd.invmgmt.dto.stock.OrderDetailDto;
import org.sxd.invmgmt.dto.stock.OrderDto;
import org.sxd.invmgmt.entity.base.Pagination;
import org.sxd.invmgmt.service.authc.UserService;
import org.sxd.invmgmt.service.stock.OrderService;
import org.sxd.invmgmt.utils.DateHelper;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shenxudong
 * @date 2020/6/10 12:16 上午
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/orders")
    public Result<List<OrderDetailDto>> getList(OrderDto orderDto, Pagination pagination) {
        if (! SecurityUtils.getSubject().hasRole("admin")) {
            String currentUserName = (String) SecurityUtils.getSubject().getPrincipal();
            UserDto userDto = userService.findByUsername(currentUserName).getObj();
            orderDto.setUserId(userDto.getId());
        }
        if (null == pagination || !pagination.isValid()) {
            pagination = Pagination.getDefaultPagination();
        }
        Result<List<OrderDto>> result = orderService.findByPage(orderDto, pagination);
        List<OrderDetailDto> list=result.getObj().stream().map((order) -> {
            order.setDateStr(DateHelper.dateToStringCommon(order.getCreateDate()));
            return orderService.orderDetail(order).getObj();
        }).collect(Collectors.toList());
        return new Result<List<OrderDetailDto>>(true, MsgEnum.OPRATION_SUCCEED.getMsg(),list,result.getTotalPage());
    }

    @PostMapping("/orders")
    public Result<Integer> createOrder(OrderDto orderDto) {
        orderDto.setCreateDate(new Date());
        return orderService.addOrder(orderDto);
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

    @PutMapping("/orders/check/{id}/{status}")
    public Result<Integer> checkOrder(@PathVariable Long id, @PathVariable Integer status) {
        OrderDto orderDto= new OrderDto();
        orderDto.setId(id);
        orderDto.setStatus(status);
        if (1 == orderDto.getStatus()) {
            return orderService.orderPass(orderDto.getId());
        }
        return orderService.orderNotPass(orderDto.getId());
    }

    @PutMapping("/orders/deliver/{id}")
    public Result<Integer> deliver(@PathVariable Long id) {
        return orderService.orderDeliver(id);
    }

    @GetMapping("/orders/detail/{id}")
    public Result<OrderDetailDto> getDetail(@PathVariable Long id) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        return orderService.orderDetail(orderDto);
    }
}
