package com.huyuya.maoyanlast.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huyuya.maoyanlast.commonutils.R;
import com.huyuya.maoyanlast.entity.Film;
import com.huyuya.maoyanlast.entity.vo.FIlmCatVo;
import com.huyuya.maoyanlast.mapper.FilmMapper;
import com.huyuya.maoyanlast.service.FilmService;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author huyu
 * @since 2021-06-30
 */
@RestController
@RequestMapping("/film")
@CrossOrigin
public class FilmController {
    @Resource
    FilmMapper filmMapper;
    @Resource
    FilmService filmService;

    @GetMapping("/list")
    public R list() {
        System.out.println("进入后端");
        List<Film> films = filmMapper.selectList(null);
        films.forEach(System.out::println);
        return R.ok().data("rows", films).data("total", films.size());
    }

    /**
     * 条件查询带分页的方法
     *
     * @param
     * @return
     */
    @ApiOperation(value = "多条件组合分页查询电影")
    @PostMapping("/pageFilmAsIf/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,
                                  @PathVariable long limit,
                                  @RequestBody(required = false) FIlmCatVo teacherQuery) {
        Page<Film> page = new Page<>(current, limit);

        //  构建条件
        String filmName = teacherQuery.getFilmName();
        String filmType = teacherQuery.getFilmType();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        Page<Film> filmPage = filmMapper.selectFilmByConditionPage(page, filmName, filmType, begin, end);
        // 调用方法 实现条件查询分页
        long total = filmPage.getTotal();
        // 总记录数
        List<Film> records = page.getRecords();
        // 数据data集合
        Map map = new HashMap();
        map.put("total", total);
        map.put("rows", records);

        return R.ok().data(map);
    }

    @PostMapping("/addFilm")
    public R addFilm(@RequestBody Film film) {
        int insert = filmMapper.insert(film);
        return R.ok();
    }
}

