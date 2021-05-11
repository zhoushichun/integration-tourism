
package com.ifm.modules.client.service;


import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.NewsInfo;

import java.util.List;

/**
*
* @ClassName:新闻信息 服务类
* @Description:
* @author: zhou
* @date 2021-04-29
*
*/
public interface INewsInfoService extends BaseService<NewsInfo> {


    List<NewsInfo> lists();


    List listNews();

}
