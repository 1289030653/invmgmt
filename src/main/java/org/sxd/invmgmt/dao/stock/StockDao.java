package org.sxd.invmgmt.dao.stock;

import org.sxd.invmgmt.dao.base.BaseDao;
import org.sxd.invmgmt.entity.stock.StockEntity;

/**
 * Created by eddie on 2018/4/1.
 */
public interface StockDao extends BaseDao<StockEntity> {
    StockEntity selectByCode(String code);
}
