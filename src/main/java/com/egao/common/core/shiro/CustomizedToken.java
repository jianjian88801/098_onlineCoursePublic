package com.egao.common.core.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class CustomizedToken extends UsernamePasswordToken{
	
	//登录类型，判断是普通用户登录，教师登录还是管理员登录
    private String loginType;
 
    public CustomizedToken(final String username,final String password,final Boolean remember, String loginType) {
        super(username,password,remember);
        this.loginType = loginType;
    }
 
    public String getLoginType() {
        return loginType;
    }
 
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

}
