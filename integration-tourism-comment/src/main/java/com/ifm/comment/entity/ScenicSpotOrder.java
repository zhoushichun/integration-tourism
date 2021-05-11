package com.ifm.comment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ifm.comment.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 景区订单
 * </p>
 *
 * @author zhou
 * @since 2021-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ScenicSpotOrder对象", description = "景区订单")
public class ScenicSpotOrder extends DataEntity<ScenicSpotOrder> {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "账户id")
    private Long accountId;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "景点ID")
    private Long scenicSpotId;

    @ApiModelProperty(value = "景点名称")
    private String scenicSpotName;

    @ApiModelProperty(value = "景点图片")
    private String scenicSpotPicture;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "景区-时间id")
    private Long scenicSpotDateId;


    @ApiModelProperty(value = "订单编号")
    private String orderNumber;

    @ApiModelProperty(value = "游玩时间")
    private String playTime;


    @ApiModelProperty(value = "票务数量")
    private Integer ticketNumber;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitCost;

    @ApiModelProperty(value = "总价")
    private Double totalPrice;

    @ApiModelProperty(value = "支付状态")
    private Boolean paymentStatus = false;


    @ApiModelProperty(value = "游客姓名")
    private String name;

    @ApiModelProperty(value = "证件号码")
    private String idNumber;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "联系电话")
    private String contactNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "付款时间")
    private Date timePayment;

    @ApiModelProperty(value = "二维码图片")
    private String codePicture = "http://192.168.5.220:8088/file/图片/555555-20210511024636848.png";


}
