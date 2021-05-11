
package com.ifm.modules.client.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.entity.DTO.UserInfoVo;
import com.ifm.modules.client.entity.UserInfo;
import com.ifm.modules.security.service.dto.AuthUserDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
*
* @ClassName:用户 服务类
* @Description:
* @author: zhou
* @date 2021-04-27
*
*/
public interface IUserInfoService extends BaseService<UserInfo> {

    List<UserInfo> listAll();


    UserInfo findByName(String username);

    Result login(AuthUserDto authUser, HttpServletRequest request);

    String messagesLogin(String phone);

    String verificationCode(String u_phone ,String code);

    UserInfo QueryUser(Long accountId);

    Result WeChatLogin(String code, HttpServletRequest request);

    String addWeChat(UserInfoVo userInfoVo);
}
