package com.ifm.modules.system.controller;

import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.entity.ScenicSpotProject;
import com.ifm.comment.result.Result;
import com.ifm.modules.system.service.IScenicSpotProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @ClassName:景点项目 前端控制器
 * @Description:
 * @author: zhou
 * @date 2021-04-30
 */
@RestController
@RequestMapping("/system/scenic-spot-project")
@Api(value = "/system/scenic-spot-project", tags = {"景点项目信息"})
@Slf4j
public class ScenicSpotProjectController extends BaseController {

    @Autowired
    IScenicSpotProjectService scenicSpotProjectService;

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
        List<ScenicSpotProject> list = scenicSpotProjectService.listAll();
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
    public Result add(@RequestBody ScenicSpotProject entity) {
        return scenicSpotProjectService.add(entity);
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

        boolean b = scenicSpotProjectService.doRemoveeIds(arr);
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
        return scenicSpotProjectService.deleteIds(ids);
    }
}
