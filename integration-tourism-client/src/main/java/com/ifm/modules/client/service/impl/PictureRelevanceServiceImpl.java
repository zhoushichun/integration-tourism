
package com.ifm.modules.client.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.PictureRelevance;
import com.ifm.modules.client.mapper.PictureRelevanceMapper;
import com.ifm.modules.client.service.IPictureRelevanceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*@ClassName:图片地址 服务实现类
*@Description:
*@author: zhou
*@date 2021-04-29
*
*/
@Service
public class PictureRelevanceServiceImpl extends BaseServiceImpl<PictureRelevanceMapper, PictureRelevance> implements IPictureRelevanceService {
    @Override
    public List<PictureRelevance> listAll() {
        QueryWrapper<PictureRelevance> queryWrapper = new QueryWrapper<>();
        return  baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<PictureRelevance> listAllById(Long id) {

        return baseMapper.listAllById(id);
    }


}
