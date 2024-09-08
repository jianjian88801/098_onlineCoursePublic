package com.egao.common.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.mapper.CourseMapper;
import com.egao.common.test.entity.Course;
import com.egao.common.test.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Override
    public PageResult<Course> listPage(PageParam<Course> page) {
        List<Course> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Course> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

	@Override
	public List<Course> listGgkc() {
		return baseMapper.listGgkc();
	}

	@Override
	public List<Course> listZykc() {
		return baseMapper.listZykc();
	}

	@Override
	public List<Course> listMfkc() {
		return baseMapper.listMfkc();
	}

	@Override
	public List<Course> listXie() {
		return baseMapper.listXie();
	}

}
