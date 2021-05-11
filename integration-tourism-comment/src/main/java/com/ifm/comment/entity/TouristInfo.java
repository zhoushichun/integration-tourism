package com.ifm.comment.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ifm.comment.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账号-游客
 * </p>
 *
 * @author zhou
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TouristInfo对象", description="账号-游客")
public class TouristInfo extends DataEntity<TouristInfo> {

    @JsonSerialize(using= ToStringSerializer.class)
    @ApiModelProperty(value = "账号id")
    private String accountId;

    @ApiModelProperty(value = "游客姓名")
    private String touristName;

    @ApiModelProperty(value = "证件类型")
    private String certificateType;

    @ApiModelProperty(value = "证件号码")
    private String certificateNum;

    @ApiModelProperty(value = "电话号码")
    private String phoneNumber;




}
