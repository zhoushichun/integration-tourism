package com.ifm.modules.client.entity.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysScenicSpotVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("景点ID")
    protected Long id;

    @ApiModelProperty(value = "景点名称")
    private String name;

    @ApiModelProperty(value = "主图地址")
    private String pictureAdds;

    @ApiModelProperty(value = "最低价格")
    private BigDecimal price;

    @ApiModelProperty(value = "平均分")
    private BigDecimal score;

    @ApiModelProperty(value = "评价条数")
    private Integer evaluationNum;

}
