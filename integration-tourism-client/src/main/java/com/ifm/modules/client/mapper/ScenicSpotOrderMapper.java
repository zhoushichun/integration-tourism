package com.ifm.modules.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.comment.entity.ScenicSpotOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName:景区订单 Mapper 接口
 * @Description:
 * @author: zhou
 * @date 2021-05-07
 */
@Mapper
@Repository
public interface ScenicSpotOrderMapper extends BaseMapper<ScenicSpotOrder> {


}
