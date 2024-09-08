package com.egao.common.core.shiro;

import com.egao.common.system.entity.UserTwo;
import com.egao.common.system.service.UserTwoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * Shiro认证和授权
 * Created by wangfan on 2017-04-28 09:45
 */
public class UserRealm extends AuthorizingRealm {
    @Lazy
    @Autowired
    private UserTwoService userTwoService;

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        UserTwo user = userTwoService.getByUsername(username);
        if (user == null) throw new UnknownAccountException(); // 账号不存在
        if (user.getState() != 0) throw new LockedAccountException();  // 账号被锁定
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

}
