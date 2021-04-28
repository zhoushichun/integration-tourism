package com.ifm.modules.quartz.utils;


import com.ifm.comment.utils.RedisUtils;
import com.ifm.comment.utils.ThrowableUtil;
import com.ifm.config.thread.ThreadPoolExecutorUtil;
import com.ifm.modules.system.entity.SysQuartzJob;
import com.ifm.modules.system.entity.SysQuartzLog;
import com.ifm.modules.system.service.ISysQuartzJobService;
import com.ifm.modules.system.service.ISysQuartzLogService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 参考人人开源，https://gitee.com/renrenio/renren-security
 * @author /
 * @date 2019-01-07
 */
@Async
@Slf4j
@SuppressWarnings({"unchecked","all"})
public class ExecutionJob extends QuartzJobBean {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    ISysQuartzJobService sysQuartzJobService;


    @Autowired
    ISysQuartzLogService sysQuartzLogService;

//    @Autowired
//    PayService payService;



    /** 该处仅供参考 */
    private final static ThreadPoolExecutor EXECUTOR = ThreadPoolExecutorUtil.getPoll();



    @Override
    public void executeInternal(JobExecutionContext context) {
        SysQuartzJob quartzJob = (SysQuartzJob) context.getMergedJobDataMap().get(SysQuartzJob.JOB_KEY);

        SysQuartzLog log = new SysQuartzLog();
        log.setJobName(quartzJob.getJobName());
        log.setBeanName(quartzJob.getBeanName());
        log.setMethodName(quartzJob.getMethodName());
        log.setParams(quartzJob.getParams());
        long startTime = System.currentTimeMillis();
        log.setCronExpression(quartzJob.getCronExpression());
        try {
            // 执行任务
            System.out.println("--------------------------------------------------------------");
            System.out.println("任务开始执行，任务名称：" + quartzJob.getJobName());

            QuartzRunnable task = new QuartzRunnable(quartzJob.getBeanName(), quartzJob.getMethodName(),
                    quartzJob.getParams());
            Future<?> future = EXECUTOR.submit(task);
            future.get();
            long times = System.currentTimeMillis() - startTime;
            log.setTime(times);
            // 任务状态
            log.setIsSuccess(true);
            System.out.println("任务执行完毕，任务名称：" + quartzJob.getJobName() + ", 执行时间：" + times + "毫秒");
            System.out.println("--------------------------------------------------------------");


        } catch (Exception e) {
            System.out.println("任务执行失败，任务名称：" + quartzJob.getJobName());
            System.out.println("--------------------------------------------------------------");
            long times = System.currentTimeMillis() - startTime;
            log.setTime(times);
            // 任务状态 0：成功 1：失败
            log.setIsSuccess(false);
            log.setExceptionDetail(ThrowableUtil.getStackTrace(e));
            // 任务如果失败了则暂停
            if(quartzJob.getPauseAfterFailure() != null && quartzJob.getPauseAfterFailure()){
                quartzJob.setIsPause(false);
                //更新状态
                sysQuartzJobService.updateIsPause(quartzJob);
                System.out.println("发送异常现象到邮箱");
            }
//            if(quartzJob.getEmail() != null){
//                EmailService emailService = SpringContextHolder.getBean(EmailService.class);
//                // 邮箱报警
//                EmailVo emailVo = taskAlarm(quartzJob, ThrowableUtil.getStackTrace(e));
//                emailService.send(emailVo, emailService.find());
//            }
        } finally {
            sysQuartzJobService.updateIsPause(quartzJob);
            System.out.println("保存任务执行日志");
            sysQuartzLogService.add(log);
        }
    }

//    private EmailVo taskAlarm(QuartzJob quartzJob, String msg) {
//        EmailVo emailVo = new EmailVo();
//        emailVo.setSubject("定时任务【"+ quartzJob.getJobName() +"】执行失败，请尽快处理！");
//        Map<String, Object> data = new HashMap<>(16);
//        data.put("task", quartzJob);
//        data.put("msg", msg);
//        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("template", TemplateConfig.ResourceMode.CLASSPATH));
//        Template template = engine.getTemplate("email/taskAlarm.ftl");
//        emailVo.setContent(template.render(data));
//        List<String> emails = Arrays.asList(quartzJob.getEmail().split("[,，]"));
//        emailVo.setTos(emails);
//        return emailVo;
//    }
}
