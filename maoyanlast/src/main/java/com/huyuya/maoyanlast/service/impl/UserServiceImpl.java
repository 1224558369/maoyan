package com.huyuya.maoyanlast.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huyuya.maoyanlast.entity.User;
import com.huyuya.maoyanlast.mapper.UserMapper;
import com.huyuya.maoyanlast.service.UserService;
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
