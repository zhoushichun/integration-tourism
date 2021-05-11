package com.ifm.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.comment.entity.ScenicSpotOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName:订单 Mapper 接口
 * @Description:
 * @author: zhou
 * @date 2021-04-30
 */
@Mapper
@Repository
public interface ScenicSpotOrderMapper extends BaseMapper<ScenicSpotOrder> {

    /**
     * @throws
     * @Title: 物理批量删除
     * @Description: <p></p>
     * @author: zhou
     * @date: 2021-04-30
     * @param: int []arr = new int []{,}
     * @return: boolean
     */
    boolean doRemoveeIds(long[] arr);

}
