
package com.ifm.modules.client.service.impl;


import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.ScenicSpotOrder;
import com.ifm.comment.entity.ScenicSpotPrice;
import com.ifm.comment.entity.SysScenicSpot;
import com.ifm.comment.entity.TouristInfo;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.entity.DTO.OrderId;
import com.ifm.modules.client.entity.vo.ScenicSpotOrderVo;
import com.ifm.modules.client.mapper.ScenicSpotOrderMapper;
import com.ifm.modules.client.service.IScenicSpotOrderService;
import com.ifm.modules.client.service.IScenicSpotPriceService;
import com.ifm.modules.client.service.ISysScenicSpotService;
import com.ifm.modules.client.service.ITouristInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:景区订单 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-05-07
 */
@Service
public class ScenicSpotOrderServiceImpl extends BaseServiceImpl<ScenicSpotOrderMapper, ScenicSpotOrder> implements IScenicSpotOrderService {
    @Autowired
    ISysScenicSpotService sysScenicSpotService;
    @Autowired
    IScenicSpotPriceService scenicSpotPriceService;

    @Autowired
    ITouristInfoService touristInfoService;

    @Override
    public List<ScenicSpotOrder> listAll() {
        QueryWrapper<ScenicSpotOrder> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public Result addOrder(ScenicSpotOrderVo entity) {

        ScenicSpotOrder scenicSpotOrder = new ScenicSpotOrder();
        scenicSpotOrder.setAccountId(entity.getAccountId());
        SysScenicSpot sysScenicSpot = sysScenicSpotService.scenicSpotInfo(entity.getScenicSpotId());
        scenicSpotOrder.setScenicSpotId(sysScenicSpot.getId());
        scenicSpotOrder.setScenicSpotName(sysScenicSpot.getName());
        scenicSpotOrder.setScenicSpotPicture(sysScenicSpot.getPictureAdds());
        Long scenicSpotDateId = entity.getScenicSpotDateId();
        scenicSpotOrder.setScenicSpotDateId(scenicSpotDateId);
        ScenicSpotPrice scenicSpotPrice = scenicSpotPriceService.scenicSpotDate(scenicSpotDateId);
        scenicSpotOrder.setScenicSpotDateId(scenicSpotDateId);
        //订单编号
        scenicSpotOrder.setOrderNumber(IdUtil.simpleUUID());
        scenicSpotOrder.setPlayTime(scenicSpotPrice.getDate());
        scenicSpotOrder.setTicketNumber(entity.getTicketNumber());
        scenicSpotOrder.setUnitCost(scenicSpotPrice.getPrice());

        scenicSpotOrder.setTotalPrice(scenicSpotPrice.getPrice().doubleValue() * entity.getTicketNumber().doubleValue());
        //游客ID
        TouristInfo touristInfo = touristInfoService.touristInfo(entity.getTouristId());
        scenicSpotOrder.setName(touristInfo.getTouristName());
        scenicSpotOrder.setIdNumber(touristInfo.getCertificateNum());
        scenicSpotOrder.setPhone(touristInfo.getPhoneNumber());
        scenicSpotOrder.setContactNumber(entity.getContactNumber());
        //新增订单
        int insert = baseMapper.insert(scenicSpotOrder);
        if (insert != 1) {
            return Result.FAIL("新增数据失败");
        }
        OrderId orderId = new OrderId();
        orderId.setOrderId(scenicSpotOrder.getId());
        return Result.SUCCESS(orderId);

    }


    @Override
    public List<ScenicSpotOrder> listTouristOrder(Long id) {

        QueryWrapper<ScenicSpotOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_id", id).eq("status", 0).eq("deleted", 0);

        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public ScenicSpotOrder touristOrderById(Long orderId) {

        QueryWrapper<ScenicSpotOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", orderId).eq("status", 0).eq("deleted", 0);

        return baseMapper.selectOne(queryWrapper);
    }


}
