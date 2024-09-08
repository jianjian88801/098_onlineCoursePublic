package com.egao.common.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.egao.common.core.web.PageParam;
import com.egao.common.test.entity.Menur;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper接口
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
public interface MenurMapper extends BaseMapper<Menur> {

    /**
     * 分页查询
     */
    List<Menur> listPage(@Param("page") PageParam<Menur> page);

    /**
     * 查询全部
     */
    List<Menur> listAll(@Param("page") Map<String, Object> page);

}
