package com.huyuya.maoyan.service.impl;

import com.huyuya.maoyan.entity.Cat;
import com.huyuya.maoyan.mapper.CatMapper;
import com.huyuya.maoyan.service.CatService;
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
public class CatServiceImpl extends ServiceImpl<CatMapper, Cat> implements CatService {

}
