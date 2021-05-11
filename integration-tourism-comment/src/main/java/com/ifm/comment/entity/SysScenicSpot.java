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
 * 景点管理
 * </p>
 *
 * @author zhou
 * @since 2021-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysScenicSpot对象", description="景点管理")
public class SysScenicSpot extends DataEntity<SysScenicSpot> {


    @ApiModelProperty(value = "景点名称")
    private String name;

    @ApiModelProperty(value = "景点地址")
    private String address;

    @ApiModelProperty(value = "营业时间")
    private String businessHours;

    @ApiModelProperty(value = "主图地址")
    private String pictureAdds;

    @TableField(exist = false)
    @ApiModelProperty(value = "图片ID")
    private List<Long> pictureId;

    @ApiModelProperty(value = "游玩须知")
    private String notice;




}
