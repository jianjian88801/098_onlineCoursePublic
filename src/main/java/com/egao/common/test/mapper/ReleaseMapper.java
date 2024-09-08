package com.egao.common.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.egao.common.core.web.PageParam;
import com.egao.common.test.entity.Release;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * Mapper接口
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
public interface ReleaseMapper extends BaseMapper<Release> {

    /**
     * 分页查询
     */
    List<Release> listPage(@Param("page") PageParam<Release> page);

    /**
     * 查询全部
     */
    List<Release> listAll(@Param("page") Map<String, Object> page);

}
