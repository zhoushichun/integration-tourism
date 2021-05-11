
package com.ifm.modules.system.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.result.Result;
import com.ifm.comment.entity.PictureRelevance;

import java.util.List;

/**
*
* @ClassName:图片地址 服务类
* @Description:
* @author: zhou
* @date 2021-04-29
*
*/
public interface IPictureRelevanceService extends BaseService<PictureRelevance> {


    List<PictureRelevance> listAll();

    Result add(PictureRelevance entity);

    boolean doRemoveeIds(long[] arr);

    Result deleteIds(long[] ids);

}
