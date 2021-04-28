package com.ifm.modules.quartz.config;


import com.ifm.modules.quartz.utils.QuartzManage;
import com.ifm.modules.system.entity.SysQuartzJob;
import com.ifm.modules.system.service.ISysQuartzJobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Zheng Jie
 * @date 2019-01-07
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class JobRunner implements ApplicationRunner {

    @Autowired
    ISysQuartzJobService sysQuartzJobService;

    @Autowired
    QuartzManage quartzManage;

    /**
     * 项目启动时重新激活启用的定时任务
     *
     * @param applicationArguments /
     */
    @Override
    public void run(ApplicationArguments applicationArguments) {
        log.info("--------------------注入定时任务---------------------");
        List<SysQuartzJob> quartzJobs = sysQuartzJobService.findByIsPauseIsFalse();
        quartzJobs.forEach(quartzManage::addJob);
        log.info("--------------------定时任务注入完成---------------------");
    }
}
