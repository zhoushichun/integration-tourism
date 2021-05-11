
package com.ifm.modules.system.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.result.Result;
import com.ifm.modules.system.entity.SysQuartzJob;

import java.util.List;

/**
*
* @ClassName:定时任务 服务类
* @Description:
* @author: zhou
* @date 2021-04-27
*
*/
public interface ISysQuartzJobService extends BaseService<SysQuartzJob> {


    List<SysQuartzJob> listAll();

    Result add(SysQuartzJob entity);

    boolean doRemoveeIds(long[] arr);

    Result deleteIds(long[] ids);

    List<SysQuartzJob> findByIsPauseIsFalse();

    void updateIsPause(SysQuartzJob quartzJob);
}
