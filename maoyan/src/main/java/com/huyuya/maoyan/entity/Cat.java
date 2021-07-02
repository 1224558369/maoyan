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
@ApiModel(value="Cat对象", description="")
public class Cat implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型id")
    @TableId(value = "cat_id", type = IdType.ASSIGN_ID)
    private Long catId;

    @ApiModelProperty(value = "类型名称")
    private String catName;

    @ApiModelProperty(value = "0:删除 1: 未删除")
    private Integer catStatus;


}
