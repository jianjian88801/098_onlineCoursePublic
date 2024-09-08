package com.egao.common.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.entity.Menur;

import java.util.List;
import java.util.Map;

/**
 * 服务类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
public interface MenurService extends IService<Menur> {

    /**
     * 分页查询
     */
    PageResult<Menur> listPage(PageParam<Menur> page);

    /**
     * 查询所有
     */
    List<Menur> listAll(Map<String, Object> page);

}
