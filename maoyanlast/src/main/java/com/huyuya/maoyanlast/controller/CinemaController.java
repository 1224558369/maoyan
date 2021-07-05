package com.huyuya.maoyanlast.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huyuya.maoyanlast.commonutils.R;
import com.huyuya.maoyanlast.entity.Cinema;
import com.huyuya.maoyanlast.entity.Film;
import com.huyuya.maoyanlast.entity.vo.CinemaVo;
import com.huyuya.maoyanlast.mapper.CinemaMapper;
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
@RequestMapping("/film/cinema")
@CrossOrigin
public class CinemaController {
    @Resource
    CinemaMapper cinemaMapper;

    @PostMapping("/pageCondition/{current}/{limit}")
    public R pageCinema(@PathVariable long current,
                        @PathVariable long limit,
                        @RequestBody(required = false) CinemaVo cinemaVo) {
        Page<Cinema> page = new Page<>(current, limit);
        cinemaMapper.selectCinemas(page, cinemaVo.getCinemaName(), cinemaVo.getBrandId(), cinemaVo.getCinemaService());
        long total = page.getTotal();
        // 总记录数
        List<Cinema> records = page.getRecords();
        // 数据data集合
        Map map = new HashMap();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
    }

    /**
     * 查询影院信息
     *
     * @param
     * @return
     */
    @GetMapping("/getCinema/{id}")
    public R getFilm(@PathVariable Long id) {
        Cinema cinema = cinemaMapper.selectById(id);
        return R.ok().data("cinema", cinema);
    }

    /**
     * 删除影院
     *
     * @param
     * @return
     */
    @DeleteMapping("/{id}")
    public R deleteFilm(@PathVariable Long id) {
        cinemaMapper.deleteById(id);
        return R.ok();
    }

    /**
     * 修改影院
     *
     * @param
     * @return
     */
    @PostMapping("/updateCinema")
    public R updateFilm(@RequestBody Cinema cinema) {
        int i = cinemaMapper.updateById(cinema);
        return R.ok();
    }

    /**
     * 添加影院
     *
     * @param
     * @return
     */
    @PostMapping("/addCinema")
    public R addFilm(@RequestBody Cinema cinema) {
        int insert = cinemaMapper.insert(cinema);
        return R.ok();
    }


}

