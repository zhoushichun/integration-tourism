
package com.ifm.modules.client.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.SysScenicSpot;
import com.ifm.modules.client.entity.vo.EvaluationVo;
import com.ifm.modules.client.entity.vo.SysScenicSpotVo;
import com.ifm.modules.client.mapper.SysScenicSpotMapper;
import com.ifm.modules.client.service.IProjectEvaluationService;
import com.ifm.modules.client.service.ISysScenicSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:景点管理 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-04-30
 */
@Service
public class SysScenicSpotServiceImpl extends BaseServiceImpl<SysScenicSpotMapper, SysScenicSpot> implements ISysScenicSpotService {

    @Autowired
    IProjectEvaluationService projectEvaluationService;

    @Override
    public List<SysScenicSpotVo> listAll() {
        ArrayList<SysScenicSpotVo> arrayList = new ArrayList<>();

        List<SysScenicSpotVo> sysScenicSpotVos = baseMapper.selectLists();
        for (SysScenicSpotVo sysScenicSpotVo : sysScenicSpotVos) {
            Long id = sysScenicSpotVo.getId();
            SysScenicSpotVo sysScenicSpot = new SysScenicSpotVo();
            sysScenicSpot.setId(id);
            sysScenicSpot.setName(sysScenicSpotVo.getName());
            sysScenicSpot.setPictureAdds(sysScenicSpotVo.getPictureAdds());
            sysScenicSpot.setPrice(sysScenicSpotVo.getPrice());
            EvaluationVo evaluationVo = projectEvaluationService.listAlls(id);
            sysScenicSpot.setScore(evaluationVo.getScore());
            sysScenicSpot.setEvaluationNum(evaluationVo.getEvaluationNum());
            arrayList.add(sysScenicSpot);

        }
        return arrayList;
    }

    /**
     * 景点信息
     *
     * @return
     */
    @Override
    public SysScenicSpot scenicSpotInfo(Long id) {

        QueryWrapper<SysScenicSpot> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id).eq("status", 0).eq("deleted", 0);


        return baseMapper.selectOne(queryWrapper);
    }

}
