package com.ifm.comment.utils.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
public class SPage implements Serializable {

    @ApiModelProperty(value = "当前页")
    public Integer current ;

    @ApiModelProperty(value = "每页数量")
    public Integer size ;

}
