package com.ifm.comment.config;

import lombok.Data;

/**
 * 线程池配置属性类
 * @author https://juejin.im/entry/5abb8f6951882555677e9da2
 * @date 2019年10月31日14:58:18
 */
@Data
public class AsyncTaskProperties {
    // 核心线程池大小
    private int corePoolSize;
    //最大线程数
    private int maxPoolSize;
    //活跃时间
    private int keepAliveSeconds;
    //队列容量
    private int queueCapacity;
}
