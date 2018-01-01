package org.sxd.invmgmt.service.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by eddie on 2017/12/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class BaseServiceTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void add() throws Exception {

    }

    @Test
    public void edit() throws Exception {

    }

    @Test
    public void remove() throws Exception {

    }

    @Test
    public void findById() throws Exception {

    }

    @Test
    public void findOne() throws Exception {

    }

    @Test
    public void findCount() throws Exception {

    }

    @Test
    public void find() throws Exception {

    }

    @Test
    public void findAll() throws Exception {

    }

}