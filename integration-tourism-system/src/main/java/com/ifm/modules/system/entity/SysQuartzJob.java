package com.ifm.modules.system.entity;

import com.ifm.comment.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 定时任务
 * </p>
 *
 * @author zhou
 * @since 2021-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysQuartzJob对象", description="定时任务")
public class SysQuartzJob extends DataEntity<SysQuartzJob> {

    public static final String JOB_KEY = "JOB_KEY";

    @ApiModelProperty(value = "Spring Bean名称")
    private String beanName;

    @ApiModelProperty(value = "cron 表达式")
    private String cronExpression;

    @ApiModelProperty(value = "状态：1暂停、0启用")
    private Boolean isPause;

    @ApiModelProperty(value = "任务名称")
    private String jobName;

    @ApiModelProperty(value = "方法名称")
    private String methodName;

    @ApiModelProperty(value = "参数")
    private String params;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "负责人")
    private String personInCharge;

    @ApiModelProperty(value = "报警邮箱")
    private String email;

    @ApiModelProperty(value = "子任务ID")
    private String subTask;

    @ApiModelProperty(value = "任务失败后是否暂停")
    private Boolean pauseAfterFailure;




}
