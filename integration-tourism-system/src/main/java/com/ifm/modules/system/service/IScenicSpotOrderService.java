
package com.ifm.modules.system.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.ScenicSpotOrder;
import com.ifm.comment.result.Result;

import java.util.List;

/**
*
* @ClassName:订单 服务类
* @Description:
* @author: zhou
* @date 2021-04-30
*
*/
public interface IScenicSpotOrderService extends BaseService<ScenicSpotOrder> {


    List<ScenicSpotOrder> listAll();

    Result add(ScenicSpotOrder entity);

    boolean doRemoveeIds(long[] arr);

    Result deleteIds(long[] ids);

}
