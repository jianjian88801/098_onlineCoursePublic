package com.egao.common.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.system.mapper.UserTwoMapper;
import com.egao.common.system.entity.UserTwo;
import com.egao.common.system.service.UserTwoService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.util.List;
import java.util.Map;

/**
 * 用户服务实现类
 * Created by wangfan on 2018-12-24 16:10
 */
@Service
public class UserTwoServiceImpl extends ServiceImpl<UserTwoMapper, UserTwo> implements UserTwoService {


    @Override
    public UserTwo getByUsername(String username) {
        return baseMapper.selectOne(new QueryWrapper<UserTwo>().eq("username", username));
    }

    @Override
    public int insert(UserTwo userTwo) {
        return baseMapper.insert(userTwo);
    }

    @Override
    public PageResult<UserTwo> listPage(PageParam<UserTwo> page) {
        List<UserTwo> users = baseMapper.listPage(page);
        return new PageResult<>(users, page.getTotal());
    }

    @Override
    public List<UserTwo> listAll(Map<String, Object> page) {
        List<UserTwo> users = baseMapper.listAll(page);
        return users;
    }

    @Override
    public boolean comparePsw(String dbPsw, String inputPsw) {
        return dbPsw != null && dbPsw.equals(encodePsw(inputPsw));
    }

    @Override
    public String encodePsw(String psw) {
        if (psw == null) return null;
        return DigestUtils.md5DigestAsHex(psw.getBytes());
    }




}
