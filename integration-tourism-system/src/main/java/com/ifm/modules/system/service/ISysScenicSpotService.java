
package com.ifm.modules.system.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.SysScenicSpot;
import com.ifm.comment.result.Result;

import java.util.List;

/**
*
* @ClassName:景点管理 服务类
* @Description:
* @author: zhou
* @date 2021-04-30
*
*/
public interface ISysScenicSpotService extends BaseService<SysScenicSpot> {


    List<SysScenicSpot> listAll();

    Result add(SysScenicSpot entity);

    boolean doRemoveeIds(long[] arr);

    Result deleteIds(long[] ids);

}
