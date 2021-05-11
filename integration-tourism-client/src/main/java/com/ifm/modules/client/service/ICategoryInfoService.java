
package com.ifm.modules.client.service;


import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.CategoryInfo;

import java.util.List;

/**
*
* @ClassName:新闻类别 服务类
* @Description:
* @author: zhou
* @date 2021-04-29
*
*/
public interface ICategoryInfoService extends BaseService<CategoryInfo> {


    List<CategoryInfo> listAll();



}
