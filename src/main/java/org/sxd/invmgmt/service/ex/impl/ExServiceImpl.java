package org.sxd.invmgmt.service.ex.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sxd.invmgmt.dao.ex.ExDao;
import org.sxd.invmgmt.dto.ex.ExDto;
import org.sxd.invmgmt.entity.ex.ExEntity;
import org.sxd.invmgmt.service.ex.ExService;

import javax.annotation.Resource;

/**
 * Created by eddie on 2017/12/19.
 */
@Service
public class ExServiceImpl implements ExService {
    @Autowired
    private ExDao exDao;

    public int addEx(ExDto dto) {
        ExEntity entity = new ExEntity();
        entity.setMsg(dto.getMsg());
        return exDao.insert(entity);
    }

    public int editEx(ExDto dto) {
        ExEntity entity = new ExEntity();
        entity.setMsg(dto.getMsg());
        return exDao.update(entity);
    }


    public ExDto queryById(ExDto dto) {
        ExEntity entity = new ExEntity();
        entity.setMsg(dto.getMsg());
        entity = exDao.selectById(entity);
        dto.setMsg(entity.getMsg());
        return dto;
    }
}
