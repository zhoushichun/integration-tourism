
package com.ifm.modules.client.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.comment.entity.ProjectEvaluation;
import com.ifm.modules.client.entity.vo.EvaluationVo;

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


    List<ProjectEvaluation> listAll(Long id);

    EvaluationVo listAlls(Long id);



}
