package com.egao.common.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.system.entity.UserTwo;

import java.util.List;
import java.util.Map;

/**
 * 用户服务类
 * Created by wangfan on 2018-12-24 16:10
 */
public interface UserTwoService extends IService<UserTwo> {

    /**
     * 根据账号查询用户
     */
	UserTwo getByUsername(String username);

    int insert(UserTwo userTwo);


    /**
     * 关联分页查询用户
     */
    PageResult<UserTwo> listPage(PageParam<UserTwo> page);

    /**
     * 关联查询全部用户
     */
    List<UserTwo> listAll(Map<String, Object> page);

  


    /**
     * 比较用户密码
     *
     * @param dbPsw    数据库存储的密码
     * @param inputPsw 用户输入的密码
     * @return boolean
     */
    boolean comparePsw(String dbPsw, String inputPsw);

    /**
     * md5加密用户密码
     */
    String encodePsw(String psw);

}
