package com.huyuya.maoyanlast.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huyuya.maoyanlast.entity.Videohall;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author huyu
 * @since 2021-06-30
 */
public interface VideohallMapper extends BaseMapper<Videohall> {
    Page<Videohall> selectVideoHallPage(Page<Videohall> page,@Param("vname") String videoHallName, @Param("htid") Long hallTypeId,@Param("cname")String cinemaName);
}
