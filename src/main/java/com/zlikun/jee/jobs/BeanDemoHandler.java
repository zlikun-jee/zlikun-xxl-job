package com.zlikun.jee.jobs;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 任务Handler示例（Bean模式）<br>
 * 注解里的任务执行器名称必须设置（应该可以用反射获取Bean的名称来自动设置吧，可以尝试改造一下~）
 *
 * @author zlikun
 * @date 2018-09-21 14:12
 */
@Slf4j
@JobHandler("BeanDemoHandler")
public class BeanDemoHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String args) throws Exception {

        // 使用XxlJob提供的日志工具类打印的日志，可以在XXL-JOB管理端查看
        XxlJobLogger.log("XXL-JOB: 任务Handler示例（Bean模式）");

        // 模拟任务执行过程
        try {
            log.info("开始执行JobHandler，接收参数：{}", args);

            // 任务参数为 interrupt 时表示测试 interrupt，否则简单输出即可
            if (args != null && args.contains("interrupt")) {
                XxlJobLogger.log("任务开始执行");
                TimeUnit.SECONDS.sleep(15L);
                XxlJobLogger.log("任务执行中");
                TimeUnit.SECONDS.sleep(15L);
                XxlJobLogger.log("任务执行结束");
            } else {
                XxlJobLogger.log("任务执行结束");
            }

            log.info("结束执行JobHandler");
        } catch (Exception e) {
            // 由于终止任务是通过“interrupt”线程抛出“InterruptedException”异常实现，所以不能在任务中把该异常处理掉了
            // 这里把 InterruptedException 异常向上抛出，以免破坏终止功能
            if (e instanceof InterruptedException) {
                throw e;
            }
            log.error("任务执行出错!", e);
        }

        return SUCCESS;
    }

}

