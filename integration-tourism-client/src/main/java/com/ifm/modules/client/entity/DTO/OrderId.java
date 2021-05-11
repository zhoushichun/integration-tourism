package com.ifm.modules.client.entity.DTO;

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
public class OrderId implements Serializable {


    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "订单Id")
    private Long orderId;

}
