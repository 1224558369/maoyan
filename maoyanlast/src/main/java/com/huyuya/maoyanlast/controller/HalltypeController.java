package com.huyuya.maoyanlast.controller;


import com.huyuya.maoyanlast.commonutils.R;
import com.huyuya.maoyanlast.entity.Halltype;
import com.huyuya.maoyanlast.entity.Videohall;
import com.huyuya.maoyanlast.exceptionhandler.GlobalExceptionHandler;
import com.huyuya.maoyanlast.exceptionhandler.MaoYanException;
import com.huyuya.maoyanlast.mapper.HalltypeMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@RequestMapping("/film/HallType")
@CrossOrigin
public class HalltypeController {
    @Resource
    private HalltypeMapper halltypeMapper;

    /**
     * 查询全部放映厅类型
     *@param
     *@return
     */
    @GetMapping("/list")
    public R getList(){
        List<Halltype> halltypes = halltypeMapper.selectList(null);
        return R.ok().data("hallTypes",halltypes);
    }

    /**
     * 查询信息
     *
     * @param
     * @return
     */
    @GetMapping("/getHallType/{id}")
    public R getHallType(@PathVariable Long id) {
        Halltype halltype = halltypeMapper.selectById(id);
        return R.ok().data("hallType", halltype);
    }

    /**
     * 删除放映厅类型
     *
     * @param
     * @return
     */
    @DeleteMapping("/{id}")
    public R deleteHallType(@PathVariable Long id) {
        List<Halltype> halltypes = halltypeMapper.selectHallTypeAsVideoHall(id);
        if (halltypes.size() > 0) {
            throw new MaoYanException(200001, "无法删除!该分类下还有数据");
        }
        int i = halltypeMapper.deleteById(id);
        return R.ok();
    }

    /**
     * 修改放映厅信息
     *
     * @param
     * @return
     */
    @PostMapping("/updateHallType")
    public R updateFilm(@RequestBody Halltype halltype) {
        int i = halltypeMapper.updateById(halltype);
        return R.ok();
    }


    /**
     * 添加放映厅类型
     *
     * @param
     * @return
     */
    @PostMapping("/addHallType")
    public R addFilm(@RequestBody Halltype halltype) {
        int insert = halltypeMapper.insert(halltype);
        return R.ok();
    }
}

