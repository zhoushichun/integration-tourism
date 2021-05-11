package com.ifm.modules.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.comment.entity.ScenicSpotPrice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *@ClassName:景区-价格 Mapper 接口
 *@Description:
 *@author: zhou
 *@date 2021-05-06
 *
 */
 @Mapper
 @Repository
public interface ScenicSpotPriceMapper extends BaseMapper<ScenicSpotPrice> {



}
