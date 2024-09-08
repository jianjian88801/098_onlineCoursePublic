package com.egao.common.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.mapper.ReleaseMapper;
import com.egao.common.test.entity.Release;
import com.egao.common.test.service.ReleaseService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@Service
public class ReleaseServiceImpl extends ServiceImpl<ReleaseMapper, Release> implements ReleaseService {

    @Override
    public PageResult<Release> listPage(PageParam<Release> page) {
        List<Release> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Release> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
