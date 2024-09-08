package com.egao.common.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.mapper.NoticeMapper;
import com.egao.common.test.entity.Notice;
import com.egao.common.test.service.NoticeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Override
    public PageResult<Notice> listPage(PageParam<Notice> page) {
        List<Notice> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Notice> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
