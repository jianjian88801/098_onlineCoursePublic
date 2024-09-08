package com.egao.common.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.egao.common.core.web.PageParam;
import com.egao.common.test.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper接口
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 分页查询
     */
    List<Course> listPage(@Param("page") PageParam<Course> page);

    /**
     * 查询全部
     */
    List<Course> listAll(@Param("page") Map<String, Object> page);
    
    List<Course> listGgkc();
    List<Course> listZykc();
    List<Course> listMfkc();
    List<Course> listXie();

}
