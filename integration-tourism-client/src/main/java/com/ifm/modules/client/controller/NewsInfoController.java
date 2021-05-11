package com.ifm.modules.client.controller;

import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.service.INewsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @ClassName:新闻信息 前端控制器
 * @Description:
 * @author: zhou
 * @date 2021-04-29
 */
@RestController
@RequestMapping("/client/news-info")
@Api(value = "/client/news-info", tags = {"首页新闻信息"})
@Slf4j
public class NewsInfoController extends BaseController {

    @Autowired
    INewsInfoService newsInfoService;


    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2021-04-29
     * @param:
     * @return:
     */
    @ApiOperation(value = "首页新闻信息", notes = "首页新闻信息")
    @PostMapping("/listNews")
    public Result listNews() {
        List list = newsInfoService.listNews();
        return Result.SUCCESS(list);
    }

}
