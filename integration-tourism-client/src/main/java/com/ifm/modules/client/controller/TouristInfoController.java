package com.ifm.modules.client.controller;

import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.entity.TouristInfo;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.entity.DTO.Accounts;
import com.ifm.modules.client.service.ITouristInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @ClassName:账号-游客 前端控制器
 * @Description:
 * @author: zhou
 * @date 2021-05-08
 */
@RestController
@RequestMapping("/client/tourist-info")
@Api(value = "/client/tourist-info", tags = {"账号-游客信息"})
@Slf4j
public class TouristInfoController extends BaseController {

    @Autowired
    ITouristInfoService TouristInfoService;

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2021-05-08
     * @param:
     * @return:
     */
    @ApiOperation(value = "查询信息", notes = "查询信息")
    @PostMapping("/listTourist}")
    public Result listTourist(@RequestBody Accounts accounts) {
        Long id = accounts.getAccountId();

        List<TouristInfo> list = TouristInfoService.listTourist(id);
        return Result.SUCCESS(list);
    }

    /**
     * @throws
     * @Title: 增加/修改
     * @author: zhou
     * @date 2021-05-08
     * @date: 2020/5/7 16:48
     * @param:
     * @return:
     */
    @ApiOperation(value = "增加/修改", notes = "增加/修改")
    @PostMapping("/add")
    public Result add(@RequestBody TouristInfo entity) {
        return TouristInfoService.add(entity);
    }

    /**
     * @throws
     * @Title: 删除
     * @Description: <p>删除使用物理删除</p>
     * @author: zhou
     * @date 2021-05-08
     * @param:
     * @return:
     */
    @ApiOperation(value = "物理删除", notes = "物理删除")
    @PostMapping("/delete")
    public Result delete(@RequestParam long[] arr) {

        return TouristInfoService.delete(arr);
    }

    /**
     * @throws
     * @Title: 逻辑删除
     * @Description: <p>逻辑删除</p>
     * @author: zhou
     * @date 2021-05-08
     * @param:
     * @return:
     */
    @ApiOperation(value = "逻辑删除", notes = "逻辑删除")
    @PostMapping("/deleteIds")
    public Result deleteIds(@RequestParam long[] ids) {
        return TouristInfoService.deleteIds(ids);
    }
}
