package com.huyuya.maoyan.entity;

import java.math.BigDecimal;
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
@ApiModel(value="Hall对象", description="")
public class Hall implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "放映场次id")
    @TableId(value = "hall_id", type = IdType.ASSIGN_ID)
    private Long hallId;

    @ApiModelProperty(value = "电影院id")
    private Long cinemaId;

    @ApiModelProperty(value = "电影id")
    private Long filmId;

    @ApiModelProperty(value = "放映日期")
    private Date hallDate;

    @ApiModelProperty(value = "开始放映时间")
    private Date hallBeginTime;

    @ApiModelProperty(value = "放映结束时间")
    private Date hallEndTime;

    @ApiModelProperty(value = "语言版本")
    private String hallLanguage;

    @ApiModelProperty(value = "放映厅")
    private String hallVideo;

    @ApiModelProperty(value = "售价")
    private BigDecimal hallPrice;

    @ApiModelProperty(value = "0:下架")
    private Integer hallStatus;


}
