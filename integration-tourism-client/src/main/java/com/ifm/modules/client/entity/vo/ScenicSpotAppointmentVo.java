package com.ifm.modules.client.entity.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ScenicSpotAppointmentVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("景点ID")
    protected Long scenicSpotId;

//    @ApiModelProperty(value = "景点名称")
//    private String scenicSpotName;

    @ApiModelProperty(value = "票名称")
    private String ticketName;

    @ApiModelProperty(value = "日期")
    private List<DatePrice> datePrice;


    @ApiModelProperty(value = "游客")
    private List<Tourist> tourist;





}
