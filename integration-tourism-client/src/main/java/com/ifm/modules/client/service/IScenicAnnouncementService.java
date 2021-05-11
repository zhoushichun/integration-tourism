
package com.ifm.modules.client.service;


import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.ScenicAnnouncement;

import java.util.List;

/**
*
* @ClassName:景区公告 服务类
* @Description:
* @author: zhou
* @date 2021-04-29
*
*/
public interface IScenicAnnouncementService extends BaseService<ScenicAnnouncement> {


    List<ScenicAnnouncement> listAll();


    ScenicAnnouncement lists();

}
