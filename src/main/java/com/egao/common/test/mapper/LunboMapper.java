package com.egao.common.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.egao.common.core.web.PageParam;
import com.egao.common.test.entity.Lunbo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * Mapper接口
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
public interface LunboMapper extends BaseMapper<Lunbo> {

    /**
     * 分页查询
     */
    List<Lunbo> listPage(@Param("page") PageParam<Lunbo> page);

    /**
     * 查询全部
     */
    List<Lunbo> listAll(@Param("page") Map<String, Object> page);

}
