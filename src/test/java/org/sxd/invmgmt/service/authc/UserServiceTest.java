package org.sxd.invmgmt.service.authc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.sxd.invmgmt.dto.authc.UserDto;
import org.sxd.invmgmt.entity.authc.UserEntity;
import org.sxd.invmgmt.service.base.BaseServiceTest;

import static org.junit.Assert.*;

/**
 * Created by eddie on 2017/12/31.
 */
public class UserServiceTest extends BaseServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUser() throws Exception {

    }

    @Test
    public void changePassword() throws Exception {

    }

    @Test
    public void findByUsername() throws Exception {
        UserDto userDto = userService.findByUsername("admin").getObj();
        System.out.println(userDto);
    }

    @Test
    public void findRoles() throws Exception {

    }

    @Test
    public void findPermissions() throws Exception {

    }

}