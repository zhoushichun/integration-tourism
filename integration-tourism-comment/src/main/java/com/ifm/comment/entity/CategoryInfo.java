package com.ifm.comment.entity;

import com.ifm.comment.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 新闻类别
 * </p>
 *
 * @author zhou
 * @since 2021-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "CategoryInfo对象", description = "新闻类别")
public class CategoryInfo extends DataEntity<CategoryInfo> {

    @ApiModelProperty(value = "类别名称")
    private String categoryName;

}
