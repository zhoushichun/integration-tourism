package com.ifm.modules.client.controller;

import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.entity.vo.SysScenicSpotVo;
import com.ifm.modules.client.service.ISysScenicSpotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @ClassName:景点管理 前端控制器
 * @Description:
 * @author: zhou
 * @date 2021-04-30
 */
@RestController
@RequestMapping("/client/sys-scenic-spot")
@Api(value = "/client/sys-scenic-spot", tags = {"景点列表"})
@Slf4j
public class SysScenicSpotController extends BaseController {

    @Autowired
    ISysScenicSpotService sysScenicSpotService;

    /**
     * @throws
     * @Title: 景点列表信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2021-04-30
     * @param:
     * @return:
     */
    @ApiOperation(value = "景点列表", notes = "景点列表")
    @PostMapping("/listAll")
    public Result listAll() {
        List<SysScenicSpotVo> list = sysScenicSpotService.listAll();
        return Result.SUCCESS(list);
    }


//    @ApiOperation(value = "景点信息", notes = "景点信息")
//    @PostMapping("/scenicSpotInfo")
//    public Result scenicSpotInfo(Long id) {
//        SysScenicSpot sysScenicSpot = sysScenicSpotService.scenicSpotInfo( id);
//        return Result.SUCCESS(sysScenicSpot);
//    }

}
