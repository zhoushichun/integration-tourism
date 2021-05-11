package ${package.Controller};

import com.ifm.comment.result.Result;
import com.ifm.comment.base.controller.BaseController;
import com.ifm.modules.system.entity.${table.entityName};
import com.ifm.modules.system.service.${table.serviceName};
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>


/**
*
* @ClassName:${table.comment!} 前端控制器
* @Description:
* @author: ${author}
* @date ${date}
*
*/
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@Api(value="<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>",tags={"${table.comment!}信息"})
@Slf4j
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} extends BaseController{
</#if>

    @Autowired
    ${table.serviceName}  ${table.entityName}Service;

    /**
    * @Title: 查询信息
    * @Description: <p></p>
    * @author: ${author}
    * @date ${date}
    * @param:
    * @return:
    * @throws
    */
    @ApiOperation(value = "查询信息", notes = "查询信息")
    @PostMapping("/list")
    public Result list(){
    List<${table.entityName}> list = ${table.entityName}Service.listAll();
    return Result.SUCCESS(list);
    }

    /**
    * @Title: 增加/修改
    * @author: ${author}
    * @date ${date}
    * @date: 2020/5/7 16:48
    * @param:
    * @return:
    * @throws
    */
    @ApiOperation(value = "增加/修改", notes = "增加/修改")
    @PostMapping("/add")
    public Result add(@RequestBody ${table.entityName} entity){
    return ${table.entityName}Service.add(entity) ;
    }

    /**
    * @Title: 删除
    * @Description: <p>删除使用物理删除</p>
    * @author: ${author}
    * @date ${date}
    * @param:
    * @return:
    * @throws
    */
    @ApiOperation(value = "物理删除", notes = "物理删除")
    @PostMapping("/delete")
    public Result delete(@RequestParam long[] arr){

    return  ${table.entityName}Service.delete(arr) ;
    }

    /**
    * @Title: 逻辑删除
    * @Description: <p>逻辑删除</p>
    * @author: ${author}
    * @date ${date}
    * @param:
    * @return:
    * @throws
    */
    @ApiOperation(value = "逻辑删除", notes = "逻辑删除")
    @PostMapping("/deleteIds")
    public Result deleteIds(@RequestParam long[] ids){
        return ${table.entityName}Service.deleteIds(ids);
    }
}
    </#if>
