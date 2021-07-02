package com.huyuya.maoyan.service.impl;

import com.huyuya.maoyan.entity.User;
import com.huyuya.maoyan.mapper.UserMapper;
import com.huyuya.maoyan.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huyu
 * @since 2021-06-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
