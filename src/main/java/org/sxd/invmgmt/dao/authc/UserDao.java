package org.sxd.invmgmt.dao.authc;

import org.sxd.invmgmt.dao.base.BaseDao;
import org.sxd.invmgmt.entity.authc.UserEntity;

/**
 * Created by eddie on 2017/12/25.
 */
public interface UserDao extends BaseDao<UserEntity> {
    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    UserEntity selectByUsername(String username);
}
