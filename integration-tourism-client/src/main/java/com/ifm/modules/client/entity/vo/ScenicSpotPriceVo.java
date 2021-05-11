package com.ifm.modules.client.entity.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScenicSpotPriceVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "id")
    private Long  id;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "景区id")
    private Long scenicSpotId;

    @ApiModelProperty(value = "票名称")
    private String ticketName;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;
}
