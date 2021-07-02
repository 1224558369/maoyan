package com.huyuya.maoyan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@ApiModel(value="Film对象", description="")
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "电影id")
    @TableId(value = "film_id", type = IdType.ASSIGN_ID)
    private Long filmId;

    @ApiModelProperty(value = "电影名称")
    private String filmName;

    @ApiModelProperty(value = "电影主演")
    private String filmActor;

    @ApiModelProperty(value = "电影类型")
    private String filmType;

    @ApiModelProperty(value = "电影产区")
    private String filmSource;

    @ApiModelProperty(value = "上映时间")
    private Date filmRelease;

    @ApiModelProperty(value = "电影时长")
    private Integer filmDuration;

    @ApiModelProperty(value = "电影封面")
    private String filmImg;

    @ApiModelProperty(value = "电影描述")
    private String filmDescription;

    @ApiModelProperty(value = "1:上架 0:下架 2:即将上映")
    private Integer filmStatus;


}
