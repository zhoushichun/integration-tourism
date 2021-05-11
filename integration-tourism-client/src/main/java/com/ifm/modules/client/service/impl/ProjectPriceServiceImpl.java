
package com.ifm.modules.client.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.ProjectPrice;
import com.ifm.modules.client.mapper.ProjectPriceMapper;
import com.ifm.modules.client.service.IProjectPriceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:项目-价格 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-04-30
 */
@Service
public class ProjectPriceServiceImpl extends BaseServiceImpl<ProjectPriceMapper, ProjectPrice> implements IProjectPriceService {
    @Override
    public List<ProjectPrice> listAll() {
        QueryWrapper<ProjectPrice> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public ProjectPrice listPrice(Long id) {
        QueryWrapper<ProjectPrice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", id).eq("status", 0).eq("deleted", 0);
        return baseMapper.selectOne(queryWrapper);
    }

}
