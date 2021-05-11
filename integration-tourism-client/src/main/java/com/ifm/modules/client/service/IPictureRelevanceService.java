
package com.ifm.modules.client.service;


import com.ifm.comment.base.service.BaseService;
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

    List<PictureRelevance> listAllById(Long id);










}
