
package com.ifm.modules.system.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.ProjectPrice;
import com.ifm.comment.result.Result;

import java.util.List;

/**
*
* @ClassName:项目-价格 服务类
* @Description:
* @author: zhou
* @date 2021-04-30
*
*/
public interface IProjectPriceService extends BaseService<ProjectPrice> {


    List<ProjectPrice> listAll();

    Result add(ProjectPrice entity);

    boolean doRemoveeIds(long[] arr);

    Result deleteIds(long[] ids);

}
