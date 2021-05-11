
package com.ifm.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.ProjectPrice;
import com.ifm.comment.result.RCode;
import com.ifm.comment.result.Result;
import com.ifm.modules.system.mapper.ProjectPriceMapper;
import com.ifm.modules.system.service.IProjectPriceService;
import org.apache.commons.compress.utils.Lists;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
*
*@ClassName:项目-价格 服务实现类
*@Description:
*@author: zhou
*@date 2021-04-30
*
*/
@Service
public class ProjectPriceServiceImpl extends BaseServiceImpl<ProjectPriceMapper, ProjectPrice> implements IProjectPriceService {
    @Override
    public List<ProjectPrice> listAll() {
        QueryWrapper<ProjectPrice> queryWrapper = new QueryWrapper<>();
        return  baseMapper.selectList(queryWrapper);
    }

    @Override
    public Result add(ProjectPrice entity) {
        if (entity == null) {
        return Result.FAIL("不能为空");
        }
        //新增
        if (entity.getId() == null) {
        int insert = baseMapper.insert(entity);
        if (insert != 1) {
        return Result.FAIL("新增数据失败");
        }
        return Result.SUCCESS(RCode.SUCCESS);
        }
        //修改
        int update = baseMapper.updateById(entity);
        if (update != 1) {
        return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
        }

    @Override
    public boolean doRemoveeIds(long[] arr) {

        return baseMapper.doRemoveeIds(arr);

    }

    @Override
    public Result deleteIds(long[] ids) {
        ArrayList<Long> objects = Lists.newArrayList();
        for (int i = 0; i < ids.length; i++) {
            objects.add(ids[i]);
        }
        int i = baseMapper.deleteBatchIds(objects);
        if (i==0) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }
}
