package com.huyuya.maoyanlast.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huyuya.maoyanlast.entity.Authority;
import com.huyuya.maoyanlast.entity.User;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author huyu
 * @since 2021-06-29
 */
public interface UserMapper extends BaseMapper<User> {
    User getUserByName(String username);

    List<Authority> getAuthorityByUserName(String username);
}
