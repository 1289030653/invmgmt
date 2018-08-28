package org.sxd.invmgmt.web.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sxd.invmgmt.common.MsgEnum;
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

    @PostMapping("/stock")
    public Result<Integer> createStock(StockDto stockDto) {
        return stockService.add(stockDto);
    }

    @PostMapping("/stock/in")
    public Result<Integer> createOrAddStock(StockDto stockDto) {
        return stockService.createOrEditStock(stockDto);
    }

    @PostMapping("/stock/edit")
    public Result<Integer> editStock(StockDto stockDto) {
        return stockService.edit(stockDto);
    }

    @DeleteMapping("/stock/{id}")
    public Result<Integer> deleteStock(@PathVariable Long id) {
        StockDto stockDto = new StockDto();
        stockDto.setId(id);
        return stockService.remove(stockDto);
    }

    @PostMapping("/stock/add")
    public Result<Integer> addStock(StockDto stockDto) {
        return stockService.addStock(stockDto);
    }

    @PostMapping("/stock/sub")
    public Result<Integer> subStock(StockDto stockDto) {
        return stockService.subStock(stockDto);
    }
}
