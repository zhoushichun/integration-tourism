package com.ifm.modules.client.controller;

import com.ifm.comment.base.controller.BaseController;
import com.ifm.comment.entity.ProjectEvaluation;
import com.ifm.comment.result.Result;
import com.ifm.modules.client.entity.DTO.Scenic;
import com.ifm.modules.client.service.IProjectEvaluationService;
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
 * @ClassName:项目评价 前端控制器
 * @Description:
 * @author: zhou
 * @date 2021-04-30
 */
@RestController
@RequestMapping("/client/project-evaluation")
@Api(value = "/client/project-evaluation", tags = {"项目评价信息"})
@Slf4j
public class ProjectEvaluationController extends BaseController {

    @Autowired
    IProjectEvaluationService projectEvaluationService;

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
      @author: zhou
     * @date 2021-04-30
     * @param:
     * @return:
     */
    @ApiOperation(value = "查询信息", notes = "查询信息")
    @PostMapping("/list")
    public Result list(@RequestBody Scenic scenic) {

        Long id = scenic.getId();
        List<ProjectEvaluation> list = projectEvaluationService.listAll( id);
        return Result.SUCCESS(list);
    }

}
