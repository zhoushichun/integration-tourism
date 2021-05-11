
package com.ifm.modules.client.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.TouristInfo;
import com.ifm.comment.result.RCode;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.entity.vo.Tourist;
import com.ifm.modules.client.mapper.TouristInfoMapper;
import com.ifm.modules.client.service.ITouristInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:账号-游客 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-05-08
 */
@Service
public class TouristInfoServiceImpl extends BaseServiceImpl<TouristInfoMapper, TouristInfo> implements ITouristInfoService {
    @Override
    public TouristInfo touristInfo(Long id) {

        QueryWrapper<TouristInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id).eq("status", 0).eq("deleted", 0);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Result add(TouristInfo entity) {
        if (entity == null) {
            return Result.FAIL("不能为空");
        }
        //新增
        if (entity.getId() == null) {
            int insert = baseMapper.insert(entity);
            if (insert != 1) {
                return Result.FAIL("新增数据失败");
            }
            TouristInfo touristInfo = baseMapper.selectById(entity.getId());
            Tourist tourist = new Tourist();
            tourist.setTouristName(touristInfo.getTouristName());
            tourist.setPhoneNumber(touristInfo.getPhoneNumber());
            tourist.setId(touristInfo.getId());
            tourist.setCertificateNum(touristInfo.getCertificateNum());
            return Result.SUCCESS(tourist);
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
    public List<TouristInfo> listTourist(Long id) {
        QueryWrapper<TouristInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_id", id).eq("status", 0).eq("deleted", 0);
        return baseMapper.selectList(queryWrapper);
    }
}
