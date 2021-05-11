
package com.ifm.modules.client.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.ScenicAnnouncement;
import com.ifm.modules.client.mapper.ScenicAnnouncementMapper;
import com.ifm.modules.client.service.IPictureRelevanceService;
import com.ifm.modules.client.service.IScenicAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:景区公告 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-04-29
 */
@Service
public class ScenicAnnouncementServiceImpl extends BaseServiceImpl<ScenicAnnouncementMapper, ScenicAnnouncement> implements IScenicAnnouncementService {
    @Autowired
    IPictureRelevanceService pictureRelevanceService;

    @Override
    public List<ScenicAnnouncement> listAll() {
        QueryWrapper<ScenicAnnouncement> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public ScenicAnnouncement lists() {
        QueryWrapper<ScenicAnnouncement> queryWrapper = new QueryWrapper<>();
        //查询前2条数据
        queryWrapper.orderByDesc("update_date").last("limit 1");
        return baseMapper.selectOne(queryWrapper);
    }


}
