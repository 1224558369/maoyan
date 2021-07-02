package com.huyuya.maoyan.controller;


import com.huyuya.maoyan.commonutils.R;
import com.huyuya.maoyan.entity.Film;
import com.huyuya.maoyan.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

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

    @GetMapping("/list")
    public R list() {
        System.out.println("进入后端");
        List<Film> films = filmMapper.selectList(null);
        films.forEach(System.out::println);
        return R.ok().data("items", films).data("total", films.size());
    }
}

