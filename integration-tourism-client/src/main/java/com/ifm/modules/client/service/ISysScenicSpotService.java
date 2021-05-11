
package com.ifm.modules.client.service;


import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.SysScenicSpot;
import com.ifm.modules.client.entity.vo.SysScenicSpotVo;

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


    List<SysScenicSpotVo> listAll();

    SysScenicSpot scenicSpotInfo(Long id);

}
