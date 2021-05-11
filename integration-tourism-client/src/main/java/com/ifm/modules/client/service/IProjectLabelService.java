
package com.ifm.modules.client.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.ProjectLabel;

import java.util.List;

/**
*
* @ClassName:项目标签 服务类
* @Description:
* @author: zhou
* @date 2021-04-30
*
*/
public interface IProjectLabelService extends BaseService<ProjectLabel> {


    List<ProjectLabel> listAll();


    List<ProjectLabel> listLabel(Long id);
}
