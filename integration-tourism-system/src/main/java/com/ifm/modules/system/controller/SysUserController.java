package com.ifm.modules.system.controller;

import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.result.Result;
import com.ifm.modules.security.service.dto.AuthUserDto;
import com.ifm.modules.system.entity.SysUser;
import com.ifm.modules.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @ClassName:系统用户 前端控制器
 * @Description:
 * @author: zhou
 * @date 2021-04-27
 */
@RestController
@RequestMapping("/system/sys-user")
@Api(value = "/system/sys-user", tags = {"系统用户信息"})
@Slf4j
public class SysUserController extends BaseController {

    @Autowired
    ISysUserService sysUserService;

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
    @PostMapping("/list")
    public Result list() {
        List<SysUser> list = sysUserService.listAll();
        System.out.println(list);
        return Result.SUCCESS(list);


    }

    /**
     * 用户登录
     *
     * @param authUser 用户信息对象
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/login")
    @ApiOperation(value = "登录", notes = "登录")

    public Result getToken(@RequestBody AuthUserDto authUser, HttpServletRequest request) {


        String login = sysUserService.login(authUser, request);

        if (login.contains("登录成功")) {
            return Result.SUCCESS(login);
        }

        return Result.FAIL(login);
    }


    @ApiOperation(value = "生成验证码")
    @PostMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        sysUserService.getVerifyCode(request, response);
    }


    @ApiOperation(value = "发送邮件")
    @PostMapping("/sendMail")
    public Result sendMail() {
        String str = sysUserService.sendMail();
        return Result.SUCCESS(str);
    }


}
