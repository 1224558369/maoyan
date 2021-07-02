package com.huyuya.maoyan.entity;

import java.math.BigDecimal;
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
@ApiModel(value="Videohall对象", description="")
public class Videohall implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "放映厅编号")
    @TableId(value = "videohall_id", type = IdType.ASSIGN_ID)
    private Long videohallId;

    @ApiModelProperty(value = "放映厅名称")
    private String videohallName;

    @ApiModelProperty(value = "所属电影院")
    private Long cinemaId;

    @ApiModelProperty(value = "放映厅类型")
    private Long halltypeId;

    @ApiModelProperty(value = "放映厅座位数")
    private BigDecimal videohallSeating;


}
