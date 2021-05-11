
package com.ifm.modules.system.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.ProjectLabel;
import com.ifm.comment.result.Result;

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

    Result add(ProjectLabel entity);

    boolean doRemoveeIds(long[] arr);

    Result deleteIds(long[] ids);

}
