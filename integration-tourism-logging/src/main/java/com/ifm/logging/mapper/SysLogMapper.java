package com.ifm.logging.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ifm.logging.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统日志 Mapper 接口
 * </p>
 *
 * @author zhou
 * @since 2020-12-25
 */
@Mapper
@Repository
public interface SysLogMapper extends BaseMapper<SysLog> {

}
