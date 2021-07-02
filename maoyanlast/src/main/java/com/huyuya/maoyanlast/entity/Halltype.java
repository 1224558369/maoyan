package com.huyuya.maoyanlast.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
@ApiModel(value="Halltype对象", description="")
public class Halltype implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "放映厅类型id")
    @TableId(value = "halltype_id", type = IdType.ASSIGN_ID)
    private Long halltypeId;

    @ApiModelProperty(value = "放映厅类型名称")
    private String halltypeName;

    @ApiModelProperty(value = "0:删除")
    private Integer halltypeStatus;


}
