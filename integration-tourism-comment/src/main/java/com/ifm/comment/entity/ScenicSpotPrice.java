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
 * 景区-价格
 * </p>
 *
 * @author zhou
 * @since 2021-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ScenicSpotPrice对象", description="景区-价格")
public class ScenicSpotPrice extends DataEntity<ScenicSpotPrice> {


    @ApiModelProperty(value = "日期")
    private String date;

    @ApiModelProperty(value = "景区id")
    private Long scenicSpotId;

    @ApiModelProperty(value = "票名称")
    private String ticketName;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

}
