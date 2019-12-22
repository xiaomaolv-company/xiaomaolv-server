package com.xiaobo.xiaomaolv.service;

import com.xiaobo.xiaomaolv.Service.AppService;
import com.xiaobo.xiaomaolv.Service.SysUserService;
import com.xiaobo.xiaomaolv.entity.CostRecorder;
import com.xiaobo.xiaomaolv.entity.SysUser;
import com.xiaobo.xiaomaolv.util.IdUtils;
import com.xiaobo.xiaomaolv.util.OperationLogUtil;
import com.xiaobo.xiaomaolv.util.Redis.JedisUtil;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private OperationLogUtil operationLogUtil;
    @Autowired
    private AppService appService;
    @Autowired
    private JedisUtil jedisUtil;

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
        int i = operationLogUtil.addOperation(10001,"测试记录","备注");
        assert i>0;
    }

    @Test
    public void costRecorder(){
    }
}
