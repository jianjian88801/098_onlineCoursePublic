package com.egao.common.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.mapper.ClassifyMapper;
import com.egao.common.test.entity.Classify;
import com.egao.common.test.service.ClassifyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements ClassifyService {

    @Override
    public PageResult<Classify> listPage(PageParam<Classify> page) {
        List<Classify> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Classify> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
