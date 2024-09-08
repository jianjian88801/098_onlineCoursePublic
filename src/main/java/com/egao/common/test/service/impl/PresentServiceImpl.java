package com.egao.common.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.mapper.PresentMapper;
import com.egao.common.test.entity.Present;
import com.egao.common.test.service.PresentService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@Service
public class PresentServiceImpl extends ServiceImpl<PresentMapper, Present> implements PresentService {

    @Override
    public PageResult<Present> listPage(PageParam<Present> page) {
        List<Present> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Present> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
