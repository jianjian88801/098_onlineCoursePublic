package com.egao.common.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egao.common.core.web.PageParam;
import com.egao.common.core.web.PageResult;
import com.egao.common.test.mapper.OrderMapper;
import com.egao.common.test.entity.Order;
import com.egao.common.test.service.OrderService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public PageResult<Order> listPage(PageParam<Order> page) {
        List<Order> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Order> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
