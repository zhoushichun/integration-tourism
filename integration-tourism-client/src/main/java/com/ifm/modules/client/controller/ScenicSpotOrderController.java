package com.ifm.modules.client.controller;

import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.entity.ScenicSpotOrder;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.entity.DTO.Accounts;
import com.ifm.modules.client.entity.DTO.OrderId;
import com.ifm.modules.client.entity.vo.ScenicSpotOrderVo;
import com.ifm.modules.client.service.IScenicSpotOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @ClassName:景区订单 前端控制器
 * @Description:
 * @author: zhou
 * @date 2021-05-07
 */
@RestController
@RequestMapping("/client/scenic-spot-order")
@Api(value = "/client/scenic-spot-order", tags = {"景区订单信息"})
@Slf4j
public class ScenicSpotOrderController extends BaseController {

    @Autowired
    IScenicSpotOrderService scenicSpotOrderService;


    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2021-05-07
     * @param:
     * @return:
     */
    @ApiOperation(value = "查询所有订单", notes = "查询所有订单")
    @PostMapping("/listTouristOrder")
    public Result listTouristOrder(@RequestBody Accounts accounts) {
        Long id = accounts.getAccountId();
        List<ScenicSpotOrder> list = scenicSpotOrderService.listTouristOrder(id);
        return Result.SUCCESS(list);
    }

    @ApiOperation(value = "查询单个订单详情", notes = "查询单个订单详情")

    @PostMapping("/touristOrderById")
    public Result touristOrderById(@RequestBody OrderId orderId) {
        ScenicSpotOrder scenicSpotOrder = scenicSpotOrderService.touristOrderById(orderId.getOrderId());
        return Result.SUCCESS(scenicSpotOrder);
    }

    /**
     * @throws
     * @Title: 增加/修改
     * @author: zhou
     * @date 2021-05-07
     * @date: 2020/5/7 16:48
     * @param:
     * @return:
     */
    @ApiOperation(value = "提交订单", notes = "提交订单")
    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody ScenicSpotOrderVo entity) {

        return scenicSpotOrderService.addOrder(entity);
    }


}
