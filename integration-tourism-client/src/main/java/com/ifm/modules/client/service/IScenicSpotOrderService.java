
package com.ifm.modules.client.service;


import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.ScenicSpotOrder;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.entity.vo.ScenicSpotOrderVo;

import java.util.List;

/**
 * @ClassName:景区订单 服务类
 * @Description:
 * @author: zhou
 * @date 2021-05-07
 */
public interface IScenicSpotOrderService extends BaseService<ScenicSpotOrder> {


    List<ScenicSpotOrder> listAll();

    Result addOrder(ScenicSpotOrderVo entity);


    List<ScenicSpotOrder> listTouristOrder(Long id);


    ScenicSpotOrder touristOrderById(Long orderId);
}
