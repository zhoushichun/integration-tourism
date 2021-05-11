
package com.ifm.modules.client.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.ProjectLabel;
import com.ifm.modules.client.mapper.ProjectLabelMapper;
import com.ifm.modules.client.service.IProjectLabelService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*@ClassName:项目标签 服务实现类
*@Description:
*@author: zhou
*@date 2021-04-30
*
*/
@Service
public class ProjectLabelServiceImpl extends BaseServiceImpl<ProjectLabelMapper, ProjectLabel> implements IProjectLabelService {
    @Override
    public List<ProjectLabel> listAll() {
        QueryWrapper<ProjectLabel> queryWrapper = new QueryWrapper<>();
        return  baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<ProjectLabel> listLabel(Long id) {

        QueryWrapper<ProjectLabel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", id).eq("status", 0).eq("deleted", 0).last("limit 3");
        return baseMapper.selectList(queryWrapper);
    }


}
