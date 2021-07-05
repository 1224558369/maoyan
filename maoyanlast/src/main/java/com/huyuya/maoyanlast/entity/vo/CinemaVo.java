package com.huyuya.maoyanlast.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author huyu
 * @version 1.0
 * @date 2021/7/5 9:45
 */
@Data
public class CinemaVo implements Serializable {
    @ApiModelProperty(value = "电影院名称")
    private String cinemaName;

    @ApiModelProperty(value = "0代表其他品牌")
    private Long brandId;

    @ApiModelProperty(value = "电影服务")
    private String cinemaService;
}
