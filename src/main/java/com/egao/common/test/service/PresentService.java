package com.egao.common.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.entity.Present;

import java.util.List;
import java.util.Map;

/**
 * 服务类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
public interface PresentService extends IService<Present> {

    /**
     * 分页查询
     */
    PageResult<Present> listPage(PageParam<Present> page);

    /**
     * 查询所有
     */
    List<Present> listAll(Map<String, Object> page);

}
