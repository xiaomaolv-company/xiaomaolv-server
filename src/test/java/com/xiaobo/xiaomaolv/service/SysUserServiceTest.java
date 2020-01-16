package com.xiaobo.xiaomaolv.service;

import com.xiaobo.xiaomaolv.Service.AppChartService;
import com.xiaobo.xiaomaolv.Service.AppService;
import com.xiaobo.xiaomaolv.Service.SysUserService;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.ChartData;
import com.xiaobo.xiaomaolv.entity.CostRecorder;
import com.xiaobo.xiaomaolv.entity.SysUser;
import com.xiaobo.xiaomaolv.util.IdUtils;
import com.xiaobo.xiaomaolv.util.OperationLogUtil;
import com.xiaobo.xiaomaolv.util.Redis.JedisUtil;
import org.hibernate.validator.constraints.EAN;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private OperationLogUtil operationLogUtil;
    @Autowired
    private AppChartService appChartService;


    @Test
    public void userServiceTest(){
        SysUser sysUser = new SysUser();
        sysUser.setId(2);
        sysUser.setUuid(IdUtils.getUUid());
        sysUser.setName("骑毛驴放牛");
        sysUser.setMobile("15290359146");
        int i  = sysUserService.addUser(sysUser);
        assert (i>0);
    }
    @Test
    public void visitLogTest(){
        int i = operationLogUtil.addVisitUser("骑毛驴放牛",10010);
        assert i>0;
    }
    @Test
    public void operationTest(){
        ChartData chartData = new ChartData();
        chartData.setUserId(10013);
        chartData.setYear("2020");
        chartData.setMonth("01");
        AppResponse appResponse = appChartService.getChartData(chartData);
        Object obj = appResponse.getAppData();
    }


}
