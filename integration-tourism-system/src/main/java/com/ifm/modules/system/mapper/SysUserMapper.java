package com.ifm.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.modules.system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *@ClassName:系统用户 Mapper 接口
 *@Description:
 *@author: zhou
 *@date 2021-04-27
 *
 */
 @Mapper
 @Repository
public interface SysUserMapper extends BaseMapper<SysUser> {



}
