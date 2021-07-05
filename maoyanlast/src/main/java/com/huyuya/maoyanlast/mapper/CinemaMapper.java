package com.huyuya.maoyanlast.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huyuya.maoyanlast.entity.Cinema;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author huyu
 * @since 2021-06-30
 */
public interface CinemaMapper extends BaseMapper<Cinema> {
    Page<Cinema> selectCinemas(Page<Cinema> page, @Param("cname") String name, @Param("bid") Long brandId, @Param("cservice") String cservice);
}
