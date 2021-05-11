package com.ifm.modules.client.entity.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScenicSpotOrderVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "账户ID")
    private Long accountId;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "景点ID")
    private Long scenicSpotId;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "景区-时间ID")
    private Long scenicSpotDateId;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "游客ID")
    private Long touristId;

    @ApiModelProperty(value = "票务数量")
    private Integer ticketNumber;

    @ApiModelProperty(value = "联系电话")
    private String contactNumber;
}
