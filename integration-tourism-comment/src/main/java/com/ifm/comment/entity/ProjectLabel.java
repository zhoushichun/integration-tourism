package com.ifm.comment.entity;

import com.ifm.comment.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目标签
 * </p>
 *
 * @author zhou
 * @since 2021-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ProjectLabel对象", description="项目标签")
public class ProjectLabel extends DataEntity<ProjectLabel> {


    @ApiModelProperty(value = "项目id")
    private Long projectId;

    @ApiModelProperty(value = "标签名称")
    private String labelName;

}
