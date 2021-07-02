package com.huyuya.maoyanlast.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author huyu
 * @version 1.0
 * @date 2021/7/1 10:19
 */
@ApiModel(value = "电影类型查询对象", description = "电影查询对象封装")
@Data
public class FIlmCatVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String filmName;

    private String filmType;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;
    //注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}
