package com.xiaobo.xiaomaolv.service;

import com.xiaobo.xiaomaolv.Service.SysUserService;
import com.xiaobo.xiaomaolv.entity.SysUser;
import com.xiaobo.xiaomaolv.util.IdUtils;
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
}
