package com.egao.common.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.mapper.MenurMapper;
import com.egao.common.test.entity.Menur;
import com.egao.common.test.service.MenurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@Service
public class MenurServiceImpl extends ServiceImpl<MenurMapper, Menur> implements MenurService {

    @Override
    public PageResult<Menur> listPage(PageParam<Menur> page) {
        List<Menur> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Menur> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
