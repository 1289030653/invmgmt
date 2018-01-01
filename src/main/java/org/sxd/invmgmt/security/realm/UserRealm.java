package org.sxd.invmgmt.security.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.authc.UserDto;
import org.sxd.invmgmt.entity.authc.UserEntity;
import org.sxd.invmgmt.service.authc.UserService;

/**
 * Created by eddie on 2017/12/21.
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findRoles(username));
        //authorizationInfo.setStringPermissions(userService.findPermissions(username));
        return authorizationInfo;
    }

    //验证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        Result<UserDto> result = userService.findByUsername(username);
        System.out.println(result.getObj());
        UserDto user;
        if (result.isSuccess()) {
            user = result.getObj();
        } else {
            throw new UnknownAccountException();//没找到账号
        }
        if (Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()
        );
        return authenticationInfo;

    }
}
