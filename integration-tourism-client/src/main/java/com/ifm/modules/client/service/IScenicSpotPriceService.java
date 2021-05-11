
package com.ifm.modules.client.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.ScenicSpotPrice;
import com.ifm.modules.client.entity.vo.ScenicSpotAppointmentVo;
import com.ifm.modules.client.entity.vo.ScenicSpotProjectVo;

import java.util.List;

/**
 * @ClassName:景区-价格 服务类
 * @Description:
 * @author: zhou
 * @date 2021-05-06
 */
public interface IScenicSpotPriceService extends BaseService<ScenicSpotPrice> {


    List<ScenicSpotPrice> listAll();


    ScenicSpotProjectVo scenicSpotReserve(Long id);

    ScenicSpotAppointmentVo scenicSpotAppointment(Long id, Long accountId);

    ScenicSpotPrice scenicSpotDate(Long id);
}
