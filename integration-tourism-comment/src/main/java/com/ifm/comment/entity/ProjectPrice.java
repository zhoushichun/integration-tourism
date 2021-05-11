package com.ifm.comment.entity;

import com.ifm.comment.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 项目-价格
 * </p>
 *
 * @author zhou
 * @since 2021-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ProjectPrice对象", description = "项目-价格")
public class ProjectPrice extends DataEntity<ProjectPrice> {

    @ApiModelProperty(value = "景区id")
    private Long scenicSpotId;

    @ApiModelProperty(value = "项目id")
    private Long projectId;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "日期")
    private String date;

    @ApiModelProperty(value = "票数量")
    private Integer ticketAmount;


}
