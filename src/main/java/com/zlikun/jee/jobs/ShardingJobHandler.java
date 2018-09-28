package com.zlikun.jee.jobs;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.core.util.ShardingUtil;

/**
 * @author zlikun
 * @date 2018-09-25 13:45
 */
@JobHandler
public class ShardingJobHandler extends IJobHandler {
    @Override
    public ReturnT<String> execute(String param) {

        // 读取分片参数
        ShardingUtil.ShardingVO shardingVO = ShardingUtil.getShardingVo();
        // 打印分片信息
        XxlJobLogger.log("分片参数：当前分片序号 = {}, 总分片数 = {}", shardingVO.getIndex(), shardingVO.getTotal());

        return SUCCESS;
    }
}
