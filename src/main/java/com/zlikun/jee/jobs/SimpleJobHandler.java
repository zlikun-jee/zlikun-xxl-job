package com.zlikun.jee.jobs;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;

/**
 * 当 @JobHandler 未指定值时，使用类全名作为JobHandler名称：com.zlikun.jee.jobs.SimpleJobHandler
 *
 * @author zlikun
 * @date 2018-09-28 11:49
 */
@Slf4j
@JobHandler
public class SimpleJobHandler extends IJobHandler {
    @Override
    public ReturnT<String> execute(String param) {

        XxlJobLogger.log("[{}] begin execute simple-job, param => {}", System.currentTimeMillis(), param);

        XxlJobLogger.log("job is running .");

        XxlJobLogger.log("[{}] end execute simple-job", System.currentTimeMillis());

        return SUCCESS;
    }
}
