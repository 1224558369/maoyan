package com.huyuya.maoyanlast.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huyuya.maoyanlast.entity.Film;
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
public interface FilmMapper extends BaseMapper<Film> {
    Page<Film> selectFilmByConditionPage(Page<Film> page, @Param("filmName") String filmName, @Param("filmType") String filmType, @Param("begin") String begin, @Param("end") String end);
}
