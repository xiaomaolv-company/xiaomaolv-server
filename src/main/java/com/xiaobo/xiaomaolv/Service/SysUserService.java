package com.xiaobo.xiaomaolv.Service;

import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.SysUser;


public interface SysUserService {
    SysUser findByUser(SysUser sysUser);

    int addUser(SysUser user);

    AppResponse queryUserInfo();
}
