
package com.ifm.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.PictureRelevance;
import com.ifm.comment.entity.ScenicSpotProject;
import com.ifm.comment.result.RCode;
import com.ifm.comment.result.Result;
import com.ifm.modules.system.mapper.ScenicSpotProjectMapper;
import com.ifm.modules.system.service.IPictureRelevanceService;
import com.ifm.modules.system.service.IScenicSpotProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:景点项目 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-04-30
 */
@Service
public class ScenicSpotProjectServiceImpl extends BaseServiceImpl<ScenicSpotProjectMapper, ScenicSpotProject> implements IScenicSpotProjectService {
    @Autowired
    IPictureRelevanceService pictureRelevanceService;

    @Override
    public List<ScenicSpotProject> listAll() {
        QueryWrapper<ScenicSpotProject> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public Result add(ScenicSpotProject entity) {
        if (entity == null) {
            return Result.FAIL("不能为空");
        }
        //新增
        if (entity.getId() == null) {
            int insert = baseMapper.insert(entity);
            if (insert != 1) {
                return Result.FAIL("新增数据失败");
            }
            List<Long> pictureId = entity.getPictureId();
            for (Long aLong : pictureId) {
                addPicture( entity,aLong);
            }
            return Result.SUCCESS(RCode.SUCCESS);
        }
        //修改
        int update = baseMapper.updateById(entity);
        List<Long> pictureId = entity.getPictureId();
        if (pictureId.size() != 0) {
            long[] longs = {entity.getId()};
            pictureRelevanceService.doRemoveeIds(longs);
            for (Long aLong : pictureId) {
                addPicture( entity,aLong);
            }
        }
        if (update != 1) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }



    @Override
    public boolean doRemoveeIds(long[] arr) {

        return baseMapper.doRemoveeIds(arr);

    }

    public void addPicture(ScenicSpotProject entity,Long aLong){
        PictureRelevance pictureRelevance = new PictureRelevance();
        pictureRelevance.setRelevanceId(entity.getId());
        pictureRelevance.setFileId(aLong);
        pictureRelevanceService.add(pictureRelevance);
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
}
