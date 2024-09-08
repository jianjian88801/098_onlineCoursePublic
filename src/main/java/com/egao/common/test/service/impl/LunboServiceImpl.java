package com.egao.common.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.mapper.LunboMapper;
import com.egao.common.test.entity.Lunbo;
import com.egao.common.test.service.LunboService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@Service
public class LunboServiceImpl extends ServiceImpl<LunboMapper, Lunbo> implements LunboService {

    @Override
    public PageResult<Lunbo> listPage(PageParam<Lunbo> page) {
        List<Lunbo> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Lunbo> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
