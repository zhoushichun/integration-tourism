package com.ifm.modules.client.controller;


import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.entity.UserInfo;
import com.ifm.modules.client.service.IUserInfoService;
import com.ifm.modules.security.service.dto.AuthUserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
*
* @ClassName:用户 前端控制器
* @Description:
* @author: zhou
* @date 2021-04-27
*
*/
@RestController
@RequestMapping("/system/user-info")
@Api(value="/system/user-info",tags={"用户信息"})
@Slf4j
public class UserInfoController extends BaseController {

    @Autowired
    IUserInfoService UserInfoService;

    /**
    * @Title: 查询信息
    * @Description: <p></p>
    * @author: zhou
    * @date 2021-04-27
    * @param:
    * @return:
    * @throws
    */
    @ApiOperation(value = "查询信息", notes = "查询信息")
    @PostMapping("/list")
    public Result list(){
    List<UserInfo> list = UserInfoService.listAll();
    return Result.SUCCESS(list);
    }

    /**
     * 用户登录
     *
     * @param authUser 用户信息对象
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
//    @Log("登录")
    @PostMapping(value = "/login")
    @ApiOperation(value = "登录", notes = "登录")

    public Result login(@RequestBody AuthUserDto authUser, HttpServletRequest request) {


        String login = UserInfoService.login(authUser, request);

        if (login.contains("登录成功")) {
            return Result.SUCCESS(login);
        }

        return Result.FAIL(login);
    }
}
