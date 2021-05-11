package com.ifm.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.comment.entity.PictureRelevance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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

 /**
 * @Title: 物理批量删除
 * @Description: <p></p>
 * @author: zhou
 * @date: 2021-04-29
 * @param: int []arr = new int []{,}
 * @return: boolean
 * @throws
 */
 boolean doRemoveeIds(long[] arr);

}
