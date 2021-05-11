
package com.ifm.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.NewsInfo;
import com.ifm.comment.entity.PictureRelevance;
import com.ifm.comment.result.RCode;
import com.ifm.comment.result.Result;
import com.ifm.modules.system.mapper.NewsInfoMapper;
import com.ifm.modules.system.service.INewsInfoService;
import com.ifm.modules.system.service.IPictureRelevanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:新闻信息 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-04-29
 */
@Service
public class NewsInfoServiceImpl extends BaseServiceImpl<NewsInfoMapper, NewsInfo> implements INewsInfoService {
    @Autowired
    IPictureRelevanceService pictureRelevanceService;

    @Override
    public List<NewsInfo> listAll() {
        QueryWrapper<NewsInfo> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public Result add(NewsInfo entity) {
        if (entity == null) {
            return Result.FAIL("不能为空");
        }
        if (entity.getId() == null) {
            int insert = baseMapper.insert(entity);
            System.out.println(entity.getId());
            if (insert != 1) {
                return Result.FAIL("新增数据失败");
            }
            List<Long> pictureId = entity.getPictureId();
            for (Long aLong : pictureId) {
                addPicture(entity, aLong);
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
                addPicture(entity, aLong);
            }
        }
        if (update != 1) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }

    public void addPicture(NewsInfo entity, Long aLong) {
        PictureRelevance pictureRelevance = new PictureRelevance();
        pictureRelevance.setRelevanceId(entity.getId());
        pictureRelevance.setFileId(aLong);
        pictureRelevanceService.add(pictureRelevance);
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
        if (i == 0) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }
}
