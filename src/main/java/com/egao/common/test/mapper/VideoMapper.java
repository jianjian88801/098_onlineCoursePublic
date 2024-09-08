package com.egao.common.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.egao.common.core.web.PageParam;
import com.egao.common.test.entity.Video;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper接口
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
public interface VideoMapper extends BaseMapper<Video> {

    /**
     * 分页查询
     */
    List<Video> listPage(@Param("page") PageParam<Video> page);

    /**
     * 查询全部
     */
    List<Video> listAll(@Param("page") Map<String, Object> page);

}
