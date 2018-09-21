package com.zlikun.jee.jobs;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


/**
 * 任务Handler示例（Bean模式）<br>
 * 注解里的任务执行器名称必须设置（应该可以用反射获取Bean的名称来自动设置吧，可以尝试改造一下~）
 *
 * @author zlikun
 * @date 2018-09-21 14:12
 */
@Slf4j
@Component
@JobHandler("BeanDemoHandler")
public class BeanDemoHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String args) throws Exception {

        // 使用XxlJob提供的日志工具类打印的日志，可以在XXL-JOB管理端查看
        XxlJobLogger.log("XXL-JOB: 任务Handler示例（Bean模式）");

        log.info("开始执行JobHandler，接收参数：{}", args);

        // 休眠三秒，模拟执行过程
        TimeUnit.SECONDS.sleep(3L);

        log.info("结束执行JobHandler");

        return SUCCESS;
    }

}
