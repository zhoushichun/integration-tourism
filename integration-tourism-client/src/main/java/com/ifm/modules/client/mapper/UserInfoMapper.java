package com.ifm.modules.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.modules.client.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *@ClassName:用户 Mapper 接口
 *@Description:
 *@author: zhou
 *@date 2021-04-27
 *
 */
 @Mapper
 @Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {



}
