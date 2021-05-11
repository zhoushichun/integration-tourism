
package com.ifm.modules.client.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.ProjectEvaluation;
import com.ifm.modules.client.entity.vo.EvaluationVo;
import com.ifm.modules.client.mapper.ProjectEvaluationMapper;
import com.ifm.modules.client.service.IProjectEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*@ClassName:项目评价 服务实现类
*@Description:
*@author: zhou
*@date 2021-04-30
*
*/
@Service
public class ProjectEvaluationServiceImpl extends BaseServiceImpl<ProjectEvaluationMapper, ProjectEvaluation> implements IProjectEvaluationService {
    @Override
    public List<ProjectEvaluation> listAll(Long id) {
        QueryWrapper<ProjectEvaluation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("scenic_spot_id", id).eq("status", 0).eq("deleted", 0).orderByDesc("update_date").last("limit 2");

        return  baseMapper.selectList(queryWrapper);
    }

    @Override
    public EvaluationVo listAlls(Long id) {
        return baseMapper.listAlls(id);
    }

}
