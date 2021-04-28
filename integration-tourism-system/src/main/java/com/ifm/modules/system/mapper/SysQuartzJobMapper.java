package com.ifm.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.comment.result.Result;
import com.ifm.modules.system.entity.SysQuartzJob;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *@ClassName:定时任务 Mapper 接口
 *@Description:
 *@author: zhou
 *@date 2021-04-27
 *
 */
 @Mapper
 @Repository
public interface SysQuartzJobMapper extends BaseMapper<SysQuartzJob> {

 /**
 * @Title: 物理批量删除
 * @Description: <p></p>
 * @author: zhou
 * @date: 2021-04-27
 * @param: int []arr = new int []{,}
 * @return: boolean
 * @throws
 */
 Result doRemoveeIds(long[] arr);

}
