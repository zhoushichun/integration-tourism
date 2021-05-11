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
 * 景点项目
 * </p>
 *
 * @author zhou
 * @since 2021-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ScenicSpotProject对象", description = "景点项目")
public class ScenicSpotProject extends DataEntity<ScenicSpotProject> {


    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "售票时间")
    private String playTime;

    @ApiModelProperty(value = "票务信息")
    private String ticketInfo;

    @ApiModelProperty(value = "规则说明")
    private String ruleDescription;

    @ApiModelProperty(value = "项目介绍")
    private String projectDescription;

    @ApiModelProperty(value = "主图地址")
    private String pictureAdds;

    @TableField(exist = false)
    @ApiModelProperty(value = "图片ID")
    private List<Long> pictureId;


}
