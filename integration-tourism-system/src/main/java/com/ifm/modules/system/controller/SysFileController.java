package com.ifm.modules.system.controller;


import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.result.Result;
import com.ifm.modules.system.service.ISysFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * @ClassName:本地存储 前端控制器
 * @Description:
 * @author: zhou
 * @date 2021-01-21
 */
@RestController
@RequestMapping("/app/file")
@Api(value = "/app/file", tags = {"本地存储信息"})
@Slf4j
public class SysFileController extends BaseController {

    @Autowired
    ISysFileService sysFileService;


    @ApiOperation(value = "图片上传", notes = "图片上传")
    @PostMapping("/uploadPictures")
    public Result uploadPictures(@RequestParam("fileNames") MultipartFile[] files) {

        List list = sysFileService.uploadPictures(files);

        return Result.SUCCESS(list);
    }
}
