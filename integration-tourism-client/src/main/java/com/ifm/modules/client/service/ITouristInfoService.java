
package com.ifm.modules.client.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.TouristInfo;
import com.ifm.comment.result.Result;

import java.util.List;

/**
*
* @ClassName:账号-游客 服务类
* @Description:
* @author: zhou
* @date 2021-05-08
*
*/
public interface ITouristInfoService extends BaseService<TouristInfo> {


    TouristInfo touristInfo(Long id);

    Result add(TouristInfo entity);

    Result delete(long[] arr);

    Result deleteIds(long[] ids);

    List<TouristInfo> listTourist(Long id);
}
