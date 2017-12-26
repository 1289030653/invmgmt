package org.sxd.invmgmt.dao.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by eddie on 2017/12/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml"
})
public abstract class BaseDaoTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public abstract void insert() throws Exception;

    @Test
    public abstract void update() throws Exception;

    @Test
    public abstract void logicDelete() throws Exception;

    @Test
    public abstract void selectById() throws Exception;

    @Test
    public abstract void selectOne() throws Exception;

    @Test
    public void selectCount() throws Exception {

    }

    @Test
    public abstract void select() throws Exception;

    @Test
    public abstract void selectAll() throws Exception;

}