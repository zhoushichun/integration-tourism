
package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.ifm.comment.result.Result;
import com.ifm.comment.result.Result;
import org.springframework.stereotype.Service;
import ${package.Entity}.${table.entityName};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import java.util.ArrayList;
import java.util.List;

/**
*
*@ClassName:${table.comment!} 服务实现类
*@Description:
*@author: ${author}
*@date ${date}
*
*/
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends BaseServiceImpl<${table.mapperName}, ${entity}> implements ${table.serviceName} {
    @Override
    public List<${table.entityName}> listAll() {
        QueryWrapper<${table.entityName}> queryWrapper = new QueryWrapper<>();
        return  baseMapper.selectList(queryWrapper);
    }

    @Override
    public Result add(${table.entityName} entity) {
        if (entity == null) {
        return Result.FAIL("不能为空");
        }
        //新增
        if (entity.getId() == null) {
        int insert = baseMapper.insert(entity);
        if (insert != 1) {
        return Result.FAIL("新增数据失败");
        }
        return Result.SUCCESS(RCode.SUCCESS);
        }
        //修改
        int update = baseMapper.updateById(entity);
        if (update != 1) {
        return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
        }

    @Override
    public Result delete(long[] arr) {

        return baseMapper.doRemoveeIds(arr);

    }

    @Override
    public Result deleteIds(long[] ids) {
        ArrayList<Long> objects = Lists.newArrayList();
        for (int i = 0; i < ids.length; i++) {
            objects.add(ids[i]);
        }
        int i = baseMapper.deleteBatchIds(objects);
        if (i==0) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }
}
</#if>
