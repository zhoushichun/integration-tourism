package com.ifm.modules.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.comment.entity.TouristInfo;
import com.ifm.comment.result.Result;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *@ClassName:账号-游客 Mapper 接口
 *@Description:
 *@author: zhou
 *@date 2021-05-08
 *
 */
 @Mapper
 @Repository
public interface TouristInfoMapper extends BaseMapper<TouristInfo> {

 /**
 * @Title: 物理批量删除
 * @Description: <p></p>
 * @author: zhou
 * @date: 2021-05-08
 * @param: int []arr = new int []{,}
 * @return: boolean
 * @throws
 */
 Result doRemoveeIds(long[] arr);

}
