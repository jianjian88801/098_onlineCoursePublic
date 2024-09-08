package com.egao.common.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.mapper.VideoMapper;
import com.egao.common.test.entity.Video;
import com.egao.common.test.service.VideoService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Override
    public PageResult<Video> listPage(PageParam<Video> page) {
        List<Video> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Video> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
