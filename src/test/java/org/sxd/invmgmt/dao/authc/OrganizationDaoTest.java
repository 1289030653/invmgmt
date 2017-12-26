package org.sxd.invmgmt.dao.authc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.sxd.invmgmt.dao.base.BaseDaoTest;
import org.sxd.invmgmt.entity.authc.OrganizationEntity;

/**
 * Created by eddie on 2017/12/25.
 */
public class OrganizationDaoTest extends BaseDaoTest {
    @Autowired
    private OrganizationDao organizationDao;

    @Test
    public void selectAllWithExclude() throws Exception {

    }

    public void insert() throws Exception {
        OrganizationEntity entity = new OrganizationEntity("总公司", 1L, null);
        int row = organizationDao.insert(entity);
        Assert.assertEquals(1, row);
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