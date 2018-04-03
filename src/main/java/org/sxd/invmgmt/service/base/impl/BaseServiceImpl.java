package org.sxd.invmgmt.service.base.impl;

import org.sxd.invmgmt.common.BaseObject;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dao.base.BaseDao;
import org.sxd.invmgmt.dto.base.Dto;
import org.sxd.invmgmt.entity.base.Entity;
import org.sxd.invmgmt.entity.base.Pagination;
import org.sxd.invmgmt.exception.BusinessException;
import org.sxd.invmgmt.service.base.BaseService;
import org.sxd.invmgmt.utils.BeanCopyUtil;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eddie on 2017/12/19.
 */
public abstract class BaseServiceImpl<D extends Dto, E extends Entity>
    extends BaseObject implements BaseService<D> {

    protected BaseDao<E> baseDao;

    protected void baseDaoCheck() {
        if (baseDao == null) {
            logger.debug("No baseDao configured");
            throw new BusinessException("缺少baseDao");
        }
    }

    protected void dtoCheck(D dto) {
        if (dto == null) {
            logger.error("Null dto");
            throw new BusinessException("dto为空");
        }
    }

    protected void pagenationCheck(Pagination pagination) {
        if (pagination == null) {
            logger.error("Null pagination");
            throw new BusinessException("pagination为空");
        }
        if (pagination.getPage() < 1 || pagination.getPageSize() < 1) {
            logger.error("Wrong pagination");
            throw new BusinessException("分页信息有误");
        }
    }

    /**
     *
     * @param genericsClass
     * @param index
     * @return
     */
    private Object getNewInstanse(Class genericsClass, int index) {
        try {
            ParameterizedType superType = (ParameterizedType) genericsClass.getGenericSuperclass();
            Class clazz = (Class) superType.getActualTypeArguments()[index];
            return (Object) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            logger.debug(e.getMessage());
        } catch (IllegalAccessException e) {
            logger.debug(e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.debug(e.getMessage());
        }
        return null;
    }


    /**
     * dto to entity,没有对象之间的转�?br> 如果有特殊需�?请重写本方法
     *
     * @param dto
     * @return
     */

    protected E dtoToEntity(D dto) {
        if (dto != null) {
            E entity = (E) getNewInstanse(getClass(), 1);
            BeanCopyUtil.copyProperties(entity, dto);
            return entity;
        }
        return null;
    }

    /**
     * entity to dto
     *
     * @param entity
     * @return
     */
    protected D entityToDto(E entity) {
        if (entity != null) {
            D dto = (D) getNewInstanse(getClass(), 0);
            BeanCopyUtil.copyProperties(dto, entity);
            return dto;
        }
        return null;
    }

    /**
     * listEntity to listDto
     *
     * @param listEntity
     * @return
     */
    protected List<D> entityListToDtoList(List<E> listEntity) {
        List<D> listDto = new ArrayList<D>();
        for (E entity : listEntity) {
            listDto.add(entityToDto(entity));
        }
        return listDto;
    }

    /**
     * listDto to listEntity
     *
     * @param listDto
     * @return
     */
    protected List<E> dtoListToEntityList(List<D> listDto) {
        List<E> listEntity = new ArrayList<E>();
        for (D dto : listDto) {
            listEntity.add(dtoToEntity(dto));
        }
        return listEntity;
    }

    public Result<Integer> add(D dto) {
        Result<Integer> result = new Result<Integer>(false, "操作失败", null);
        baseDaoCheck();
        dtoCheck(dto);
        E entity = dtoToEntity(dto);
        int row = baseDao.insert(entity);
        if (row > 0) {
            result = new Result<Integer>(true, "添加成功", row);
        } else {
            result = new Result<Integer>(false, "添加失败", 0);
        }
        return result;
    }

    public Result<Integer> edit(D dto) {
        Result<Integer> result = new Result<Integer>(false, "操作失败", null);
        baseDaoCheck();
        dtoCheck(dto);
        E entity = dtoToEntity(dto);
        int row = baseDao.update(entity);
        if (row > 0) {
            result = new Result<Integer>(true, "修改成功", row);
        } else {
            result = new Result<Integer>(false, "修改失败", 0);
        }
        return result;
    }

    public Result<Integer> remove(D dto) {
        Result<Integer> result = new Result<Integer>(false, "操作失败", null);
        baseDaoCheck();
        dtoCheck(dto);
        E entity = dtoToEntity(dto);
        int row = baseDao.logicDelete(entity);
        if (row > 0) {
            result = new Result<Integer>(true, "删除成功", row);
        } else {
            result = new Result<Integer>(false, "删除失败", 0);
        }
        return result;
    }

    public Result<D> findById(D dto) {
        Result<D> result;
        baseDaoCheck();
        dtoCheck(dto);
        E entity = dtoToEntity(dto);
        entity = baseDao.selectById(entity);
        if (entity != null) {
            result = new Result<D>(true, "查询成功", entityToDto(entity));
        } else {
            result = new Result<D>(false, "查询失败", null);
        }
        return result;
    }

    public Result<D> findOne(D dto) {
        Result<D> result;
        baseDaoCheck();
        dtoCheck(dto);
        E entity = dtoToEntity(dto);
        entity = baseDao.selectOne(entity);
        if (entity != null) {
            result = new Result<D>(true, "查询成功", entityToDto(entity));
        } else {
            result = new Result<D>(false, "查询失败", null);
        }
        return result;
    }

    public Result<Integer> findCount(D dto) {
        Result<Integer> result;
        baseDaoCheck();
        dtoCheck(dto);
        E entity = dtoToEntity(dto);
        Integer count = baseDao.selectCount(entity);
        if (count != null) {
            result = new Result<Integer>(true, "查询成功", count);
        } else {
            result = new Result<Integer>(false, "查询失败", null);
        }
        return result;
    }

    public Result<List<D>> find(D dto) {
        Result<List<D>> result;
        baseDaoCheck();
        dtoCheck(dto);
        E entity = dtoToEntity(dto);
        List<E> entityList = baseDao.select(entity);
        if (entityList != null) {
            result = new Result<List<D>>(true, "查询成功", entityListToDtoList(entityList));
        } else {
            result = new Result<List<D>>(false, "查询失败", null);
        }
        return result;
    }

    public Result<List<D>> findAll() {
        Result<List<D>> result;
        baseDaoCheck();
        List<E> entityList = baseDao.selectAll();
        if (entityList != null) {
            result = new Result<List<D>>(true, "查询成功", entityListToDtoList(entityList));
        } else {
            result = new Result<List<D>>(true, "查询为空", null);
        }
        return result;
    }

    public Result<List<D>> findByPage(D dto, Pagination pagination) {
        Result<List<D>> result;
        baseDaoCheck();
        E entity = dtoToEntity(dto);
        Integer count = baseDao.selectCount(entity);
        entity.setStart(pagination.getStart());
        entity.setPageSize(pagination.getPageSize());
        List<E> entityList = baseDao.selectByPage(entity);
        if (entityList != null) {
            result = new Result<List<D>>(true, "查询成功", entityListToDtoList(entityList));
            result.setTotalPage((count + pagination.getPageSize() - 1) / pagination.getPageSize());
        } else {
            result = new Result<List<D>>(true, "查询为空", null);
        }
        return result;
    }
}
