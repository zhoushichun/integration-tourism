package com.ifm.comment.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ifm.comment.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 图片地址
 * </p>
 *
 * @author zhou
 * @since 2021-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PictureRelevance对象", description="图片地址")
public class PictureRelevance extends DataEntity<PictureRelevance> {


    @ApiModelProperty(value = "关联id")
    private Long relevanceId;

    @ApiModelProperty(value = "图片id")
    private Long fileId;

    @TableField(exist = false)
    @ApiModelProperty(value = "回显地址")
    private String echo;









}
