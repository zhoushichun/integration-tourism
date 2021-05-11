package com.ifm.modules.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.comment.entity.PictureRelevance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *@ClassName:图片地址 Mapper 接口
 *@Description:
 *@author: zhou
 *@date 2021-04-29
 *
 */
 @Mapper
 @Repository
public interface PictureRelevanceMapper extends BaseMapper<PictureRelevance> {



    List<PictureRelevance> listAllById(@Param("id") Long id);

}
