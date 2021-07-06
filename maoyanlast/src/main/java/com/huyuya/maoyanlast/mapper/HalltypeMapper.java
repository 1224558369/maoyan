package com.huyuya.maoyanlast.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huyuya.maoyanlast.entity.Halltype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huyu
 * @since 2021-06-30
 */
public interface HalltypeMapper extends BaseMapper<Halltype> {
    List<Halltype> selectHallTypeAsVideoHall(@Param("id") Long id);
}
