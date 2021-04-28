
package com.ifm.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.result.RCode;
import com.ifm.comment.result.Result;
import com.ifm.modules.quartz.utils.QuartzManage;
import com.ifm.modules.system.entity.SysQuartzJob;
import com.ifm.modules.system.mapper.SysQuartzJobMapper;
import com.ifm.modules.system.service.ISysQuartzJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:定时任务 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-04-27
 */
@Service
public class SysQuartzJobServiceImpl extends BaseServiceImpl<SysQuartzJobMapper, SysQuartzJob> implements ISysQuartzJobService {

    @Autowired
    QuartzManage quartzManage;

    @Override
    public List<SysQuartzJob> listAll() {
        QueryWrapper<SysQuartzJob> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public Result add(SysQuartzJob entity) {
        if (entity == null) {
            return Result.FAIL("不能为空");
        }
        //新增
        if (entity.getId() == null) {
            int insert = baseMapper.insert(entity);
            if (insert != 1) {
                return Result.FAIL("新增数据失败");
            }
            quartzManage.addJob(entity);
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
    public Result delete(long[] arr) {

        return baseMapper.doRemoveeIds(arr);

    }

    @Override
    public Result deleteIds(long[] ids) {
        ArrayList<Long> objects = Lists.newArrayList();
        for (int i = 0; i < ids.length; i++) {
            objects.add(ids[i]);
        }
        int i = baseMapper.deleteBatchIds(objects);
        if (i == 0) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }

    @Override
    public List<SysQuartzJob> findByIsPauseIsFalse() {
        QueryWrapper<SysQuartzJob> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_pause",0);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public void updateIsPause(SysQuartzJob quartzJob) {

    }
}
