package com.ifm.modules.client.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 景区公告
 * </p>
 *
 * @author zhou
 * @since 2021-04-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement implements Serializable {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "类别")
    private String category;

    @ApiModelProperty(value = "值")
    private Integer value;

    @ApiModelProperty(value = "主图片地址")
    private String pictureAdds;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;


}
