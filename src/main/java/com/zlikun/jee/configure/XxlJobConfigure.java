//package com.zlikun.jee.configure;
//
//import com.xxl.job.core.executor.XxlJobExecutor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author zlikun
// * @date 2018-09-21 14:10
// */
//@Slf4j
//@Configuration
//@ComponentScan(basePackages = "com.zlikun.jee.jobs")
//public class XxlJobConfigure {
//
//    @Value("${xxl.job.admin.addresses}")
//    private String adminAddresses;
//
//    @Value("${xxl.job.executor.appname}")
//    private String appName;
//
//    @Value("${xxl.job.executor.ip}")
//    private String ip;
//
//    @Value("${xxl.job.executor.port}")
//    private int port;
//
//    @Value("${xxl.job.accessToken}")
//    private String accessToken;
//
//    @Value("${xxl.job.executor.logpath}")
//    private String logPath;
//
//    @Value("${xxl.job.executor.logretentiondays}")
//    private int logRetentionDays;
//
//
//    @Bean(initMethod = "start", destroyMethod = "destroy")
//    public XxlJobExecutor xxlJobExecutor() {
//        log.info(">>>>>>>>>>> xxl-job config init.");
//        XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();
//        xxlJobExecutor.setAdminAddresses(adminAddresses);
//        xxlJobExecutor.setAppName(appName);
//        xxlJobExecutor.setIp(ip);
//        xxlJobExecutor.setPort(port);
//        xxlJobExecutor.setAccessToken(accessToken);
//        xxlJobExecutor.setLogPath(logPath);
//        xxlJobExecutor.setLogRetentionDays(logRetentionDays);
//
//        return xxlJobExecutor;
//    }
//
//}