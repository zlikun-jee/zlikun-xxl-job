package com.zlikun.jee.jobs;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.core.util.ShardingUtil;
import org.springframework.stereotype.Component;

/**
 * @author zlikun
 * @date 2018-09-25 13:45
 */
@Component
@JobHandler("shardingJobHandler")
public class ShardingJobHandler extends IJobHandler {
    @Override
    public ReturnT<String> execute(String param) {

        // 读取分片参数
        ShardingUtil.ShardingVO shardingVO = ShardingUtil.getShardingVo();
        // 打印分片信息（这里有个Bug，该日志组件会对占位参数格式化，但会遇到格式化错误）
        // XxlJobLogger.log("分片参数：当前分片序号 = {}, 总分片数 = {}", shardingVO.getIndex(), shardingVO.getTotal());
        // 不要用它自带的占位语法，有Bug ~
        XxlJobLogger.log(String.format("分片参数：当前分片序号 = %d, 总分片数 = %d", shardingVO.getIndex(), shardingVO.getTotal()));

        return SUCCESS;
    }
}
