package com.huyuya.maoyanlast.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huyuya.maoyanlast.commonutils.R;
import com.huyuya.maoyanlast.entity.Brand;
import com.huyuya.maoyanlast.entity.Cinema;
import com.huyuya.maoyanlast.exceptionhandler.MaoYanException;
import com.huyuya.maoyanlast.mapper.BrandMapper;
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
@RequestMapping("/film/brand")
@CrossOrigin
public class BrandController {
    @Resource
    BrandMapper brandMapper;
    @Resource
    CinemaMapper cinemaMapper;

    @GetMapping("/list")
    public R list() {
        List<Brand> brands = brandMapper.selectList(null);
        return R.ok().data("brands", brands);
    }

    @PostMapping("/pageList/{current}/{limit}")
    public R pageList(@PathVariable long current,
                      @PathVariable long limit) {
        Page<Brand> page = new Page<>(current, limit);
        brandMapper.selectPage(page, null);
        long total = page.getTotal();
        List<Brand> records = page.getRecords();
        // 数据data集合
        Map map = new HashMap();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
    }


    /**
     * 修改品牌信息
     *
     * @param
     * @return
     */
    @PostMapping("/updateBrand")
    public R updateFilm(@RequestBody Brand brand) {
        int i = brandMapper.updateById(brand);
        return R.ok();
    }

    /**
     * 添加影院
     *
     * @param
     * @return
     */
    @PostMapping("/addBrand")
    public R addFilm(@RequestBody Brand brand) {
        int insert = brandMapper.insert(brand);
        return R.ok();
    }

    /**
     * 查询品牌信息
     *
     * @param
     * @return
     */
    @GetMapping("/getBrand/{id}")
    public R getFilm(@PathVariable Long id) {
        Brand brand = brandMapper.selectById(id);
        return R.ok().data("brand", brand);
    }

    /**
     * 删除品牌
     *
     * @param
     * @return
     */
    @DeleteMapping("/{id}")
    public R deleteFilm(@PathVariable Long id) {
        QueryWrapper<Cinema> queryWrapper = new QueryWrapper();
        queryWrapper.eq("brand_id", id);
        List<Cinema> cinemas = cinemaMapper.selectList(queryWrapper);
        if (cinemas.size()>0) {
            throw new MaoYanException(20001, "该数据外键关联,无法删除");
        }
        int i = brandMapper.deleteById(id);
        return R.ok();
    }

}

