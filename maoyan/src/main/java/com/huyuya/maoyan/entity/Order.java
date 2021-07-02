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
@ApiModel(value="Order对象", description="")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "电影票订单流水号")
    @TableId(value = "order_id", type = IdType.ASSIGN_ID)
    private Long orderId;

    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "用户昵称")
    private String userNick;

    @ApiModelProperty(value = "场次id")
    private Long hallId;

    @ApiModelProperty(value = "电影放映时间")
    private Date showTime;

    @ApiModelProperty(value = "放映日期")
    private Date showDate;

    @ApiModelProperty(value = "放映厅名称")
    private String hallName;

    @ApiModelProperty(value = "所属电影编号")
    private Long filmId;

    @ApiModelProperty(value = "电影名称（中文）")
    private String filmName;

    @ApiModelProperty(value = "电影票座位（x排x座）")
    private String orderPosition;

    @ApiModelProperty(value = "订单价格")
    private BigDecimal orderPrice;

    @ApiModelProperty(value = "订单支付时间")
    private Date orderTime;

    @ApiModelProperty(value = "0:支付中 1:支付完成 2:退票完成")
    private Integer orderStatus;


}
