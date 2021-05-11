
package com.ifm.modules.client.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.CategoryInfo;
import com.ifm.modules.client.mapper.CategoryInfoMapper;
import com.ifm.modules.client.service.ICategoryInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:新闻类别 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-04-29
 */
@Service
public class CategoryInfoServiceImpl extends BaseServiceImpl<CategoryInfoMapper, CategoryInfo> implements ICategoryInfoService {
    @Override
    public List<CategoryInfo> listAll() {
        QueryWrapper<CategoryInfo> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }


}
