package com.huyuya.maoyan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author huyu
 * @since 2021-06-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Cinema对象", description="")
public class Cinema implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "电影院id")
    @TableId(value = "cinema_id", type = IdType.ASSIGN_ID)
    private Long cinemaId;

    @ApiModelProperty(value = "电影院名称")
    private String cinemaName;

    @ApiModelProperty(value = "电影院具体位置")
    private String cinemaSite;

    @ApiModelProperty(value = "电影院联系电话")
    private String cinemaPhone;

    @ApiModelProperty(value = "0代表其他品牌")
    private Long brandId;

    @ApiModelProperty(value = "0:下架 1:上映")
    private Integer cinemaStatus;


}
