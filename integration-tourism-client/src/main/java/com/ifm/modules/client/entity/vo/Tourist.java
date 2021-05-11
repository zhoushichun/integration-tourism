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
public class Tourist implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "游客姓名")
    private String touristName;

    @ApiModelProperty(value = "证件号码")
    private String certificateNum;

    @ApiModelProperty(value = "电话号码")
    private String phoneNumber;
}
