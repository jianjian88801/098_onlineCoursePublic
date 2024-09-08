package com.egao.common.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.egao.common.core.web.PageParam;
import com.egao.common.test.entity.Order;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * Mapper接口
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 分页查询
     */
    List<Order> listPage(@Param("page") PageParam<Order> page);

    /**
     * 查询全部
     */
    List<Order> listAll(@Param("page") Map<String, Object> page);

}
