package com.egao.common.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.egao.common.core.web.PageParam;
import com.egao.common.test.entity.Classify;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper接口
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
public interface ClassifyMapper extends BaseMapper<Classify> {

    /**
     * 分页查询
     */
    List<Classify> listPage(@Param("page") PageParam<Classify> page);

    /**
     * 查询全部
     */
    List<Classify> listAll(@Param("page") Map<String, Object> page);

}
