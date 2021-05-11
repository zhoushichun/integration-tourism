
package com.ifm.modules.system.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.ProjectEvaluation;
import com.ifm.comment.result.Result;

import java.util.List;

/**
*
* @ClassName:项目评价 服务类
* @Description:
* @author: zhou
* @date 2021-04-30
*
*/
public interface IProjectEvaluationService extends BaseService<ProjectEvaluation> {


    List<ProjectEvaluation> listAll();

    Result add(ProjectEvaluation entity);

    boolean doRemoveeIds(long[] arr);

    Result deleteIds(long[] ids);

}
