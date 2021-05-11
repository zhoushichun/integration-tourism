package com.ifm.comment.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ifm.comment.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 新闻信息
 * </p>
 *
 * @author zhou
 * @since 2021-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "NewsInfo对象", description = "新闻信息")
public class NewsInfo extends DataEntity<NewsInfo> {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "分类")
    private String category;

    @ApiModelProperty(value = "值")
    private Integer value;

    @ApiModelProperty(value = "主图地址")
    private String pictureAdds;

    @TableField(exist = false)
    @ApiModelProperty(value = "图片ID")
    private List<Long> pictureId;




}
