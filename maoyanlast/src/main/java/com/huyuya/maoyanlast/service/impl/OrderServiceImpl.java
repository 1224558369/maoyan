package com.huyuya.maoyanlast.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huyuya.maoyanlast.entity.Order;
import com.huyuya.maoyanlast.mapper.OrderMapper;
import com.huyuya.maoyanlast.service.OrderService;
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
