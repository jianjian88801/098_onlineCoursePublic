package com.egao.common.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.entity.Video;

import java.util.List;
import java.util.Map;

/**
 * 服务类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
public interface VideoService extends IService<Video> {

    /**
     * 分页查询
     */
    PageResult<Video> listPage(PageParam<Video> page);

    /**
     * 查询所有
     */
    List<Video> listAll(Map<String, Object> page);

}
