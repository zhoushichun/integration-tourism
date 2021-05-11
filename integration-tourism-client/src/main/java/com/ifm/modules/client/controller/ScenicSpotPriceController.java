package com.ifm.modules.client.controller;

import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.entity.ScenicSpotPrice;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.entity.DTO.AccountScenic;
import com.ifm.modules.client.entity.DTO.Scenic;
import com.ifm.modules.client.entity.vo.ScenicSpotAppointmentVo;
import com.ifm.modules.client.entity.vo.ScenicSpotProjectVo;
import com.ifm.modules.client.service.IScenicSpotPriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName:景区-价格 前端控制器
 * @Description:
 * @author: zhou
 * @date 2021-05-06
 */
@RestController
@RequestMapping("/client/scenic-spot-price")
@Api(value = "/client/scenic-spot-price", tags = {"景区"})
@Slf4j
public class ScenicSpotPriceController extends BaseController {

    @Autowired
    IScenicSpotPriceService scenicSpotPriceService;

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2021-05-06
     * @param:
     * @return:
     */
    @ApiOperation(value = "查询信息", notes = "查询信息")
    @PostMapping("/ScenicSpotDate")
    public Result ScenicSpotDate(Long id) {
        ScenicSpotPrice list = scenicSpotPriceService.scenicSpotDate(id);
        return Result.SUCCESS(list);
    }

    @ApiOperation(value = "景区详情页", notes = "景区详情页")
    @PostMapping(value = "/scenicSpotReserve")
    public Result<ScenicSpotProjectVo> scenicSpotReserve(@RequestBody Scenic scenic) {
        Long id = scenic.getId();
        ScenicSpotProjectVo scenicSpotProjectVo = scenicSpotPriceService.scenicSpotReserve(id);
        return Result.SUCCESS(scenicSpotProjectVo);
    }

    @ApiOperation(value = "景区预定页", notes = "景区预定页")
    @PostMapping("/scenicSpotAppointment")
    public Result scenicSpotAppointment(@RequestBody AccountScenic accountScenic) {
        Long accountId = accountScenic.getAccountId();
        Long id = accountScenic.getId();
        ScenicSpotAppointmentVo scenicSpotAppointmentVo = scenicSpotPriceService.scenicSpotAppointment(id, accountId);
        return Result.SUCCESS(scenicSpotAppointmentVo);
    }


}
