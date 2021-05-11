
package ${package.Service};

import com.ifm.comment.result.Result;
import com.ifm.comment.base.service.BaseService;
import com.yfm.system.entity.${table.entityName};
import java.util.List;
/**
*
* @ClassName:${table.comment!} 服务类
* @Description:
* @author: ${author}
* @date ${date}
*
*/
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends BaseService<${table.entityName}> {


    List<${table.entityName}> listAll();

    Result add(${table.entityName} entity);

    Result delete(long[] arr);

    Result deleteIds(long[] ids);

}
</#if>
