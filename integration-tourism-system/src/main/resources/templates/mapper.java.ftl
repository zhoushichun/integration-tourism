package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import com.yfm.comment.result.Result;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *@ClassName:${table.comment!} Mapper 接口
 *@Description:
 *@author: ${author}
 *@date ${date}
 *
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
 @Mapper
 @Repository
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

 /**
 * @Title: 物理批量删除
 * @Description: <p></p>
 * @author: ${author}
 * @date: ${date}
 * @param: int []arr = new int []{,}
 * @return: boolean
 * @throws
 */
 Result doRemoveeIds(long[] arr);

}
</#if>
