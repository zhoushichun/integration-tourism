
package com.ifm.modules.system.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.result.Result;
import com.ifm.modules.system.entity.SysQuartzLog;

import java.util.List;

/**
*
* @ClassName:定时任务日志 服务类
* @Description:
* @author: zhou
* @date 2021-04-27
*
*/
public interface ISysQuartzLogService extends BaseService<SysQuartzLog> {


    List<SysQuartzLog> listAll();

    Result add(SysQuartzLog entity);

    boolean doRemoveeIds(long[] arr);

    Result deleteIds(long[] ids);

}
