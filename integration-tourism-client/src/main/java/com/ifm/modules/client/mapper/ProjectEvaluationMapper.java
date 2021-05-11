package com.ifm.modules.client.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.comment.entity.ProjectEvaluation;
import com.ifm.modules.client.entity.vo.EvaluationVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName:项目评价 Mapper 接口
 * @Description:
 * @author: zhou
 * @date 2021-04-30
 */
@Mapper
@Repository
public interface ProjectEvaluationMapper extends BaseMapper<ProjectEvaluation> {


    EvaluationVo listAlls(@Param("id") Long id);
}
