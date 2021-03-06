package com.ifm.logging.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Zheng Jie
 * @date 2018-11-24
 */
@Data
public class SysLog  implements Serializable {

    private Long id;

    /** 操作用户 */
    private String username;

    /** 描述 */
    private String description;

    /** 方法名 */
    private String method;

    /** 参数 */
    private String params;

    /** 日志类型 */
    private String logType;

    /** 请求ip */
    private String requestIp;

    /** 地址 */
    private String address;

    /** 浏览器  */
    private String browser;

    /** 请求耗时 */
    private Long time;

    /** 异常详细  */
    private byte[] exceptionDetail;

    /** 创建日期 */
    private Timestamp createTime;

    public SysLog(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }
}
