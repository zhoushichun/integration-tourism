package com.ifm.modules.client.controller;


import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.entity.DTO.*;
import com.ifm.modules.client.entity.UserInfo;
import com.ifm.modules.client.service.IUserInfoService;
import com.ifm.modules.security.service.dto.AuthUserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName:用户 前端控制器
 * @Description:
 * @author: zhou
 * @date 2021-04-27
 */
@RestController
@RequestMapping("/client/user-info")
@Api(value = "/client/user-info", tags = {"用户信息"})
@Slf4j
public class UserInfoController extends BaseController {

    @Autowired
    IUserInfoService UserInfoService;

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2021-04-27
     * @param:
     * @return:
     */
    @ApiOperation(value = "查询信息", notes = "查询信息")
    @PostMapping("/QueryUser")
    public Result QueryUser(@RequestBody Accounts accounts) {
        UserInfo userInfo = UserInfoService.QueryUser(accounts.getAccountId());
        return Result.SUCCESS(userInfo);
    }

    /**
     * 用户登录
     *
     * @param authUser 用户信息对象
     * @return 操作结果
     */
//    @Log("登录")
    @PostMapping(value = "/login")
    @ApiOperation(value = "账号密码登录", notes = "账号密码登录")

    public Result login(@RequestBody AuthUserDto authUser, HttpServletRequest request) {


        return UserInfoService.login(authUser, request);

    }

    @PostMapping(value = "/messagesLogin")
    @ApiOperation(value = "验证码登录-获取验证码", notes = "验证码登录-获取验证码")

    public Result messagesLogin(@RequestBody Phone p) {

        String phone = p.getPhone();

        String login = UserInfoService.messagesLogin(phone);

        if (login.contains("发送成功")) {

            return Result.SUCCESS("发送成功");
        }

        return Result.FAIL(login);
    }

    @PostMapping(value = "/verificationCode")
    @ApiOperation(value = "验证-验证码", notes = "验证-验证码登录")

    public Result verificationCode(@RequestBody PhoneCode phoneCode) {
        String code = phoneCode.getCode();
        String phone = phoneCode.getPhone();

        String login = UserInfoService.verificationCode(phone, code);

        if (login.contains("登录失败")) {

            return Result.FAIL();
        }
        return Result.SUCCESS(login);
    }


    /**
     * 微信用户登录
     *
     * @param
     * @return 操作结果
     * @throws
     */
//    @Log("登录")
    @PostMapping(value = "/WeChatLogin")
    @ApiOperation(value = "微信用户登录", notes = "微信用户登录")

    public Result WeChatLogin(@RequestBody CodeInfo codeInfo, HttpServletRequest request) {

        return UserInfoService.WeChatLogin(codeInfo.getCode(), request);

    }

    //    @Log("登录")
    @PostMapping(value = "/addWeChat")
    @ApiOperation(value = "微信用户信息添加", notes = "微信用户信息添加")

    public Result addWeChat(@RequestBody UserInfoVo userInfoVo) {

        String msg = UserInfoService.addWeChat(userInfoVo);
        return Result.SUCCESS(msg);

    }
}
