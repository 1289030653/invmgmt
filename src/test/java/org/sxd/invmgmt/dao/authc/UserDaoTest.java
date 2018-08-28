package org.sxd.invmgmt.dao.authc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.sxd.invmgmt.dao.base.BaseDaoTest;
import org.sxd.invmgmt.dao.stock.OrderDao;
import org.sxd.invmgmt.entity.authc.UserEntity;
import org.sxd.invmgmt.entity.base.Pagination;
import org.sxd.invmgmt.entity.stock.OrderEntity;

import java.util.List;

/**
 * Created by eddie on 2017/12/25.
 */
public class UserDaoTest extends BaseDaoTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderDao orderDao;

    @Test
    public void selectByUsername() throws Exception {
        UserEntity entity = userDao.selectByUsername("admin");
        Long id = entity.getId();
        System.out.println(entity);
        //entity.setName("asdfasd");
    }

    @Test
    public void selectByPage() throws Exception {
        OrderEntity entity = new OrderEntity();
        entity.setId(1l);
        //entity = orderDao.selectByPage(entity).get(0);
        entity = orderDao.selectById(entity);
        System.out.println(entity.getUserId());
        System.out.println(entity.getDeptId());
    }

    public void insert() throws Exception {

    }

    public void update() throws Exception {

    }

    public void logicDelete() throws Exception {

    }

    public void selectById() throws Exception {
    }

    public void selectOne() throws Exception {

    }

    public void select() throws Exception {

    }

    public void selectAll() throws Exception {

    }


}