package com.egao.common.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.egao.common.core.web.PageParam;
import com.egao.common.system.entity.UserTwo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 用户Mapper接口
 * Created by wangfan on 2018-12-24 16:10
 */
public interface UserTwoMapper extends BaseMapper<UserTwo> {

    /**
     * 分页查询
     */
    List<UserTwo> listPage(@Param("page") PageParam<UserTwo> page);

    /**
     * 查询全部
     */
    List<UserTwo> listAll(@Param("page") Map<String, Object> page);

}
