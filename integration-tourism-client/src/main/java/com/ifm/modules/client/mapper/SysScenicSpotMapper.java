package com.ifm.modules.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.comment.entity.SysScenicSpot;
import com.ifm.modules.client.entity.vo.SysScenicSpotVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName:景点管理 Mapper 接口
 * @Description:
 * @author: zhou
 * @date 2021-04-30
 */
@Mapper
@Repository
public interface SysScenicSpotMapper extends BaseMapper<SysScenicSpot> {


    List<SysScenicSpotVo> selectLists();

}
