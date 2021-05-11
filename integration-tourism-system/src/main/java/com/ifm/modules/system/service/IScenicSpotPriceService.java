
package com.ifm.modules.system.service;


import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.ScenicSpotPrice;
import com.ifm.comment.result.Result;

import java.util.List;

/**
*
* @ClassName:景区-价格 服务类
* @Description:
* @author: zhou
* @date 2021-05-06
*
*/
public interface IScenicSpotPriceService extends BaseService<ScenicSpotPrice> {


    List<ScenicSpotPrice> listAll();

    Result add(ScenicSpotPrice entity);

    boolean delete(long[] arr);

    Result deleteIds(long[] ids);

}
