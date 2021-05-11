package com.ifm.modules.system.controller;

import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.entity.SysScenicSpot;
import com.ifm.comment.result.Result;
import com.ifm.modules.system.service.ISysScenicSpotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @ClassName:景点管理 前端控制器
 * @Description:
 * @author: zhou
 * @date 2021-04-30
 */
@RestController
@RequestMapping("/system/sys-scenic-spot")
@Api(value = "/system/sys-scenic-spot", tags = {"景点管理信息"})
@Slf4j
public class SysScenicSpotController extends BaseController {

    @Autowired
    ISysScenicSpotService sysScenicSpotService;

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2021-04-30
     * @param:
     * @return:
     */
    @ApiOperation(value = "查询信息", notes = "查询信息")
    @PostMapping("/list")
    public Result list() {
        List<SysScenicSpot> list = sysScenicSpotService.listAll();
        return Result.SUCCESS(list);
    }

    /**
     * @throws
     * @Title: 增加/修改
     * @author: zhou
     * @date 2021-04-30
     * @date: 2020/5/7 16:48
     * @param:
     * @return:
     */
    @ApiOperation(value = "增加/修改", notes = "增加/修改")
    @PostMapping("/add")
    public Result add(@RequestBody SysScenicSpot entity) {
        return sysScenicSpotService.add(entity);
    }

    /**
     * @throws
     * @Title: 删除
     * @Description: <p>删除使用物理删除</p>
     * @author: zhou
     * @date 2021-04-30
     * @param:
     * @return:
     */
    @ApiOperation(value = "物理删除", notes = "物理删除")
    @PostMapping("/delete")
    public Result doRemoveeIds(@RequestParam long[] arr) {

        boolean b = sysScenicSpotService.doRemoveeIds(arr);

        return Result.SUCCESS(b);
    }

    /**
     * @throws
     * @Title: 逻辑删除
     * @Description: <p>逻辑删除</p>
     * @author: zhou
     * @date 2021-04-30
     * @param:
     * @return:
     */
    @ApiOperation(value = "逻辑删除", notes = "逻辑删除")
    @PostMapping("/deleteIds")
    public Result deleteIds(@RequestParam long[] ids) {
        return sysScenicSpotService.deleteIds(ids);
    }
}
