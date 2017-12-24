package org.sxd.invmgmt.service.base.impl;

import org.sxd.invmgmt.common.BaseObject;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dao.base.BaseDao;
import org.sxd.invmgmt.dto.base.Dto;
import org.sxd.invmgmt.entity.base.Entity;
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
        return null;
    }

    public Result<Integer> remove(D dto) {
        return null;
    }

    public Result<D> queryById(D dto) {
        return null;
    }

    public Result<D> queryOne(D dto) {
        return null;
    }

    public Result<D> queryCount(D dto) {
        return null;
    }

    public List<D> query(D dto) {
        return null;
    }

    public List<D> queryAll(D dto) {
        return null;
    }
}
