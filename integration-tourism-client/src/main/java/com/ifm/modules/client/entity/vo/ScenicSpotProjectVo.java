package com.ifm.modules.client.entity.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScenicSpotProjectVo implements Serializable {


    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("景点ID")
    protected Long scenicSpotId;

    @ApiModelProperty(value = "景点名称")
    private String scenicSpotName;

    @ApiModelProperty(value = "景点地址")
    private String address;

    @ApiModelProperty(value = "营业时间")
    private String businessHours;

    @ApiModelProperty(value = "景点标签")
    private List<String> label;

    @ApiModelProperty(value = "图片")
    private List<String> pictureAdds;

    @ApiModelProperty(value = "平均分")
    private BigDecimal score;

    @ApiModelProperty(value = "评价条数")
    private Integer evaluationNum;

    @ApiModelProperty(value = "景区价格")
    private List<ScenicSpotPriceVo> scenicSpotPriceVo;


    @ApiModelProperty(value = "项目评价")
    private List<ProjectEvaluationVo> projectEvaluations;

}
