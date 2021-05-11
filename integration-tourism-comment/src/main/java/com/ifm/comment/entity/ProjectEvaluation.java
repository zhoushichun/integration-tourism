package com.ifm.comment.entity;

import com.ifm.comment.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目评价
 * </p>
 *
 * @author zhou
 * @since 2021-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ProjectEvaluation对象", description="项目评价")
public class ProjectEvaluation extends DataEntity<ProjectEvaluation> {


    @ApiModelProperty(value = "项目id")
    private Long projectId;

    @ApiModelProperty(value = "账号id")
    private Long accountId;

    @ApiModelProperty(value = "景区id")
    private Long scenicSpotId;

    @ApiModelProperty(value = "评价内容")
    private String evaluationContent;

    @ApiModelProperty(value = "评价分数1.2.3.4.5")
    private Integer score;

    @ApiModelProperty(value = "审核0未审核1已审核")
    private Boolean audit;




}
