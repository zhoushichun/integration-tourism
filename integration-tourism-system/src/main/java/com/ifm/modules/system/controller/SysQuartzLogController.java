package com.ifm.modules.system.controller;

import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.result.Result;
import com.ifm.modules.system.entity.SysQuartzLog;
import com.ifm.modules.system.service.ISysQuartzLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
*
* @ClassName:定时任务日志 前端控制器
* @Description:
* @author: zhou
* @date 2021-04-27
*
*/
@RestController
@RequestMapping("/system/sys-quartz-log")
@Api(value="/system/sys-quartz-log",tags={"定时任务日志信息"})
@Slf4j
public class SysQuartzLogController extends BaseController {

    @Autowired
    ISysQuartzLogService sysQuartzLogService;

    /**
    * @Title: 查询信息
    * @Description: <p></p>
    * @author: zhou
    * @date 2021-04-27
    * @param:
    * @return:
    * @throws
    */
    @ApiOperation(value = "查询信息", notes = "查询信息")
    @PostMapping("/list")
    public Result list(){
    List<SysQuartzLog> list = sysQuartzLogService.listAll();
    return Result.SUCCESS(list);
    }

    /**
    * @Title: 增加/修改
    * @author: zhou
    * @date 2021-04-27
    * @date: 2020/5/7 16:48
    * @param:
    * @return:
    * @throws
    */
    @ApiOperation(value = "增加/修改", notes = "增加/修改")
    @PostMapping("/add")
    public Result add(@RequestBody SysQuartzLog entity){
    return sysQuartzLogService.add(entity) ;
    }

    /**
    * @Title: 删除
    * @Description: <p>删除使用物理删除</p>
    * @author: zhou
    * @date 2021-04-27
    * @param:
    * @return:
    * @throws
    */
    @ApiOperation(value = "物理删除", notes = "物理删除")
    @PostMapping("/delete")
    public Result doRemoveeIds(@RequestParam long[] arr){

        boolean b = sysQuartzLogService.doRemoveeIds(arr);
        return Result.SUCCESS(b);
    }

    /**
    * @Title: 逻辑删除
    * @Description: <p>逻辑删除</p>
    * @author: zhou
    * @date 2021-04-27
    * @param:
    * @return:
    * @throws
    */
    @ApiOperation(value = "逻辑删除", notes = "逻辑删除")
    @PostMapping("/deleteIds")
    public Result deleteIds(@RequestParam long[] ids){
        return sysQuartzLogService.deleteIds(ids);
    }
}
