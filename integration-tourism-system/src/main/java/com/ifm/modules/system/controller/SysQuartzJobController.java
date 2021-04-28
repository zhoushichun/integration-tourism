package com.ifm.modules.system.controller;

import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.result.Result;
import com.ifm.modules.system.entity.SysQuartzJob;
import com.ifm.modules.system.service.ISysQuartzJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
*
* @ClassName:定时任务 前端控制器
* @Description:
* @author: zhou
* @date 2021-04-27
*
*/
@RestController
@RequestMapping("/system/sys-quartz-job")
@Api(value="/system/sys-quartz-job",tags={"定时任务信息"})
@Slf4j
public class SysQuartzJobController extends BaseController {

    @Autowired
    ISysQuartzJobService sysQuartzJobService;

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
    List<SysQuartzJob> list = sysQuartzJobService.listAll();
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
    public Result add(@RequestBody SysQuartzJob entity){
    return sysQuartzJobService.add(entity) ;
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
    public Result delete(@RequestParam long[] arr){

    return  sysQuartzJobService.delete(arr) ;
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
        return sysQuartzJobService.deleteIds(ids);
    }
}
