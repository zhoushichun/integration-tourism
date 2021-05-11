package com.ifm.modules.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.comment.entity.NewsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName:新闻信息 Mapper 接口
 * @Description:
 * @author: zhou
 * @date 2021-04-29
 */
@Mapper
@Repository
public interface NewsInfoMapper extends BaseMapper<NewsInfo> {

    /**
     * @throws
     * @Title: 物理批量删除
     * @Description: <p></p>
     * @author: zhou
     * @date: 2021-04-29
     * @param: int []arr = new int []{,}
     * @return: boolean
     */
    boolean doRemoveeIds(long[] arr);

}
