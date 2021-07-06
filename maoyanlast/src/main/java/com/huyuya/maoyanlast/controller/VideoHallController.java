package com.huyuya.maoyanlast.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huyuya.maoyanlast.commonutils.R;
import com.huyuya.maoyanlast.entity.Cinema;
import com.huyuya.maoyanlast.entity.Videohall;
import com.huyuya.maoyanlast.entity.vo.CinemaVo;
import com.huyuya.maoyanlast.entity.vo.VideoHallVo;
import com.huyuya.maoyanlast.mapper.VideohallMapper;
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
@RequestMapping("/film/videoHall")
@CrossOrigin
public class VideoHallController {
    @Resource
    private VideohallMapper videohallMapper;

    @PostMapping("/pageCondition/{current}/{limit}")
    public R pageVideoHall(@PathVariable long current,
                           @PathVariable long limit,
                           @RequestBody(required = false) VideoHallVo videoHallVo) {
        Page<Videohall> page = new Page<>(current, limit);

        videohallMapper.selectVideoHallPage(page, videoHallVo.getVideohallName(), videoHallVo.getHalltypeId(), videoHallVo.getCinemaName());
        // 总记录数
        long total = page.getTotal();

        List<Videohall> records = page.getRecords();
        // 数据data集合
        Map map = new HashMap();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
    }

    /**
     * 查询信息
     *
     * @param
     * @return
     */
    @GetMapping("/getVideoHall/{id}")
    public R getVideoHall(@PathVariable Long id) {
        Videohall videohall = videohallMapper.selectById(id);
        return R.ok().data("videoHall", videohall);
    }

    /**
     * 删除放映厅信息
     *
     * @param
     * @return
     */
    @DeleteMapping("/{id}")
    public R deleteVideoHall(@PathVariable Long id) {
        int i = videohallMapper.deleteById(id);
        return R.ok();
    }

    /**
     * 修改放映厅信息
     *
     * @param
     * @return
     */
    @PostMapping("/updateVideoHall")
    public R updateFilm(@RequestBody Videohall videohall) {
        int i = videohallMapper.updateById(videohall);
        return R.ok();
    }

    /**
     * 添加影院
     *
     * @param
     * @return
     */
    @PostMapping("/addVideoHall")
    public R addVideoHall(@RequestBody Videohall videohall) {
        int insert = videohallMapper.insert(videohall);
        return R.ok();
    }
}

