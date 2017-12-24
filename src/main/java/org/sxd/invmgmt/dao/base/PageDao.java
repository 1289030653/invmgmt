package org.sxd.invmgmt.dao.base;

import java.util.List;

/**
 * Created by eddie on 2017/12/19.
 */
public interface PageDao<T> {
    /**
     * @desc sql中以“and =”方式附加entity中的条件，根据条件分页查询
     * @param entity
     * @return List<T>
     */
    public List<T> selectPage(T entity);

    /**
     * @desc 分页查询全部记录
     * @param entity
     * @return List<T>
     */
    public List<T> selectAllPage(T entity);
}
