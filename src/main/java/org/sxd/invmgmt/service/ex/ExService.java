package org.sxd.invmgmt.service.ex;

import org.springframework.stereotype.Service;
import org.sxd.invmgmt.dao.ex.ExDao;
import org.sxd.invmgmt.dto.ex.ExDto;

/**
 * Created by eddie on 2017/12/19.
 */
public interface ExService {
    public int addEx(ExDto dto);

    public int editEx(ExDto dto);


    public ExDto queryById(ExDto dto);
}
