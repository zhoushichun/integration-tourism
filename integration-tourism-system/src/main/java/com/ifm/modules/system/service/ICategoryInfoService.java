
package com.ifm.modules.system.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.result.Result;
import com.ifm.comment.entity.CategoryInfo;

import java.util.List;

/**
 * @ClassName:新闻类别 服务类
 * @Description:
 * @author: zhou
 * @date 2021-04-29
 */
public interface ICategoryInfoService extends BaseService<CategoryInfo> {


    List<CategoryInfo> listAll();

    Result add(CategoryInfo entity);

    boolean doRemoveeIds(long[] arr);

    Result deleteIds(long[] ids);

}
