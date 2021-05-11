package com.ifm.modules.client.controller;


import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.entity.ProjectLabel;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.entity.DTO.Scenic;
import com.ifm.modules.client.service.IProjectLabelService;
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
 * @ClassName:项目标签 前端控制器
 * @Description:
 * @author: zhou
 * @date 2021-04-30
 */
@RestController
@RequestMapping("/client/project-label")
@Api(value = "/client/project-label", tags = {"项目标签信息"})
@Slf4j
public class ProjectLabelController extends BaseController {

    @Autowired
    IProjectLabelService projectLabelService;

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2021-04-30
     * @param:
     * @return:
     */
    @ApiOperation(value = "景区标签", notes = "景区标签")
    @PostMapping("/listLabel")
    public Result listLabel(@RequestBody Scenic scenic) {

        Long id = scenic.getId();
        List<ProjectLabel> list = projectLabelService.listLabel(id);
        return Result.SUCCESS(list);
    }

}
