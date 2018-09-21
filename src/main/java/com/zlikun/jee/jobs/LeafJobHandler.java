package com.zlikun.jee.jobs;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 子任务，测试时针对该任务配置两个任务（使用不同的参数）<br>
 * 将子任务配置成为BeanDemoHandler的子任务，以测试任务间的驱动关系
 *
 * @author zlikun
 * @date 2018-09-21 15:18
 */
@Slf4j
@Component
@JobHandler("LeafJobHandler")
public class LeafJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) {

        String jobName = "default";
        if (param != null) {
            jobName = param;
        }

        XxlJobLogger.log("执行子任务：" + jobName);

        return ReturnT.SUCCESS;
    }

}
