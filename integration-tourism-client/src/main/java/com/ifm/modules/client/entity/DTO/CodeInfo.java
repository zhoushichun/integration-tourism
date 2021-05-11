package com.ifm.modules.client.entity.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeInfo implements Serializable {

    @ApiModelProperty(value = "code")
    private String code;




}
