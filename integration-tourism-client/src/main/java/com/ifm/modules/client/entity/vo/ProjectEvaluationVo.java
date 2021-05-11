package com.ifm.modules.client.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEvaluationVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "评价内容")
    private String evaluationContent;

    @ApiModelProperty(value = "评价人id")
    private Long accountId;

    @ApiModelProperty(value = "头像地址")
    private String headPortrait;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "更新时间")
    private Date evaluationTime;

    @ApiModelProperty(value = "评价分数1.2.3.4.5")
    private Integer score;

    @ApiModelProperty(value = "图片地址")
    private String evaluationAdds;
}
