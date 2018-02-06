package org.sxd.invmgmt.dao.base;

import org.sxd.invmgmt.entity.base.Entity;

import java.util.List;

/**
 * Created by eddie on 2017/12/19.
 * @desc 基本的CRUD操作
 */
public interface BaseDao<E extends Entity> {
    /**
     * @desc 插入对象
     * @param entity
     * @return
     */
    public int insert(E entity);

    /**
     * @desc 更新对象
     * @param entity
     * @return int
     */
    public int update(E entity);

    /**
     * @desc 逻辑删除对象
     * @param entity
     * @return int
     */
    public int logicDelete(E entity);

    /**
     * @desc 通过id查询对象
     * @param entity
     * @return entity
     */
    public E selectById(E entity);

    /**
     * @desc sql中以“and =”方式附加domain中的条件并且使用limit 1
     * @param entity
     * @return entity
     */
    public E selectOne(E entity);

    /**
     * @desc sql中以“and =”方式附加entity中的条件，查询记录的条数
     * @param entity
     * @return entity
     */
    public int selectCount(E entity);

    /**
     * @desc sql中以“and =”方式附加domain中的条件，根据条件查询
     * @param entity
     * @return List<entity>
     */
    public List<E> select(E entity);

    /**
     * @desc 查询全部记录
     * @param
     * @return List<entity>
     */
    public List<E> selectAll();

}
