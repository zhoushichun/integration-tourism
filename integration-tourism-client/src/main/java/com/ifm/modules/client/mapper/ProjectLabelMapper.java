package com.ifm.modules.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.comment.entity.ProjectLabel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *@ClassName:项目标签 Mapper 接口
 *@Description:
 *@author: zhou
 *@date 2021-04-30
 *
 */
 @Mapper
 @Repository
public interface ProjectLabelMapper extends BaseMapper<ProjectLabel> {

 /**
 * @Title: 物理批量删除
 * @Description: <p></p>
 * @author: zhou
 * @date: 2021-04-30
 * @param: int []arr = new int []{,}
 * @return: boolean
 * @throws
 */
 boolean doRemoveeIds(long[] arr);

}
