package com.huyuya.maoyan.service.impl;

import com.huyuya.maoyan.entity.Order;
import com.huyuya.maoyan.mapper.OrderMapper;
import com.huyuya.maoyan.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huyu
 * @since 2021-06-30
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
