package com.egao.common.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.entity.Release;
import java.util.List;
import java.util.Map;

/**
 * 服务类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
public interface ReleaseService extends IService<Release> {

    /**
     * 分页查询
     */
    PageResult<Release> listPage(PageParam<Release> page);

    /**
     * 查询所有
     */
    List<Release> listAll(Map<String, Object> page);

}
