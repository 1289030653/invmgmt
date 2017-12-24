package org.sxd.invmgmt.service.base;

import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.base.Dto;
import org.sxd.invmgmt.entity.base.Entity;

import java.util.List;

/**
 * Created by eddie on 2017/12/19.
 */
public interface BaseService<D extends Dto> {
    /**
     * @desc 插入对象
     * @param dto
     * @return Result<T>
     */
    public Result<Integer> add(D dto);

    /**
     * @desc 更新对象
     * @param dto
     * @return
     */
    public Result<Integer> edit(D dto);

    /**
     * @desc 逻辑删除对象
     * @param dto
     * @return
     */
    public Result<Integer> remove(D dto);

    /**
     * @desc 通过id查询
     * @param dto
     * @return
     */
    public Result<D> queryById(D dto);

    /**
     * @desc 查询单个(limt 1)
     * @param dto
     * @return
     */
    public Result<D> queryOne(D dto);

    /**
     * 查询数量
     * @param dto
     * @return
     */
    public Result<D> queryCount(D dto);

    /**
     * @desc 根据条件查询
     * @param dto
     * @return
     */
    public List<D> query(D dto);

    /**
     * @desc 查询所有
     * @param dto
     * @return
     */
    public List<D> queryAll(D dto);
}
