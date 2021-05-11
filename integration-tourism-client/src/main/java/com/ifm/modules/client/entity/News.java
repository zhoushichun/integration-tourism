package com.ifm.modules.client.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 新闻信息
 * </p>
 *
 * @author zhou
 * @since 2021-04-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News implements Serializable {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "类型")
    private String category;

    @ApiModelProperty(value = "值")
    private Integer  value;



}
