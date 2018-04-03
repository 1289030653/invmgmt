package org.sxd.invmgmt.web.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.stock.StockDto;
import org.sxd.invmgmt.entity.base.Pagination;
import org.sxd.invmgmt.service.stock.StockService;

import java.util.List;

/**
 * Created by eddie on 2018/4/3.
 */
@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/stock")
    public Result<List<StockDto>> getList(StockDto stockDto, Pagination pagination) {
        if (null == pagination || !pagination.isValid()) {
            pagination = Pagination.getDefaultPagination();
        }
        return stockService.findByPage(stockDto, pagination);
    }


}
