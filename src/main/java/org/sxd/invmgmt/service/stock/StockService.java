package org.sxd.invmgmt.service.stock;

import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.stock.StockDto;
import org.sxd.invmgmt.service.base.BaseService;

/**
 * Created by eddie on 2018/4/2.
 */
public interface StockService extends BaseService<StockDto> {
    /**
     * 新增
     */
    Result<Integer> createStock(StockDto stockDto);

    /**
     * 增加库存
     */
    Result<Integer> addStock(StockDto stockDto);

    /**
     * 减少库存
     */
    Result<Integer> subStock(StockDto stockDto);

    /**
     * 编辑
     */
    Result<Integer> editStock(StockDto stockDto);

}
