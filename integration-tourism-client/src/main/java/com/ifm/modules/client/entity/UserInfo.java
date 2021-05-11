package com.ifm.modules.client.entity;

import com.ifm.comment.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author zhou
 * @since 2021-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserInfo对象", description="用户")
public class UserInfo extends DataEntity<UserInfo> {

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像地址")
    private String avatarName;

    @ApiModelProperty(value = "头像真实路径")
    private String avatarPath;

    @ApiModelProperty(value = "余额")
    private Double balance;

    @ApiModelProperty(value = "积分")
    private Integer point;

    @ApiModelProperty(value = "最后登录时间")
    private LocalDateTime logonTime;

    @ApiModelProperty(value = "最后登录IP")
    private String logonIp;

    @ApiModelProperty(value = "openid")
    private String openId;

    @ApiModelProperty(value = "账号")
    private String account;



}
