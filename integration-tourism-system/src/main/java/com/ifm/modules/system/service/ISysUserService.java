
package com.ifm.modules.system.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.modules.security.service.dto.AuthUserDto;
import com.ifm.modules.system.entity.SysUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
*
* @ClassName:系统用户 服务类
* @Description:
* @author: zhou
* @date 2021-04-27
*
*/
public interface ISysUserService extends BaseService<SysUser> {


    List<SysUser> listAll();


    SysUser findByName(String username);

    String login(AuthUserDto authUser, HttpServletRequest request);

}
