package com.ifm.modules.client.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationVo  implements Serializable {


    @ApiModelProperty(value = "平均分")
    private BigDecimal score;

    @ApiModelProperty(value = "评价条数")
    private Integer evaluationNum;
}
