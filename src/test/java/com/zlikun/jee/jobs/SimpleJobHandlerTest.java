package com.zlikun.jee.jobs;

import com.xxl.job.core.biz.model.ReturnT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author zlikun
 * @date 2018-09-28 12:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleJobHandlerTest {

    @Autowired
    private SimpleJobHandler jobHandler;

    @Test
    public void execute() {
        ReturnT<String> returnT = jobHandler.execute("name=zlikun");
        assertEquals(ReturnT.SUCCESS.getCode(), returnT.getCode());
    }
}