package com.ifm.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.modules.system.entity.SysQuartzLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName:定时任务日志 Mapper 接口
 * @Description:
 * @author: zhou
 * @date 2021-04-27
 */
@Mapper
@Repository
public interface SysQuartzLogMapper extends BaseMapper<SysQuartzLog> {

    /**
     * @throws
     * @Title: 物理批量删除
     * @Description: <p></p>
     * @author: zhou
     * @date: 2021-04-27
     * @param: int []arr = new int []{,}
     * @return: boolean
     */
    boolean doRemoveeIds(long[] arr);

}
